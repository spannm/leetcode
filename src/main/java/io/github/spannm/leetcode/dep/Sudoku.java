package io.github.spannm.leetcode.dep;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sudoku {

    private static final int BOARD_SIZE = 9;
    private static final int BOX_SIZE   = 3;

    public static final class Solver {

        private final boolean outputEnabled;

        public Solver() {
            this(true);
        }

        public Solver(boolean _outputEnabled) {
            outputEnabled = _outputEnabled;
        }

        void doOutput(String _format, Object... _args) {
            if (outputEnabled) {
                System.out.printf(_format, _args);
            }
        }

        public boolean solve(Board _board) {
            doOutput("%s%n%n", _board);

            int maxLoops = 15;
            int loopCount = 0;
            while (!_board.isSolved() && ++loopCount < maxLoops) {
                doOutput("** Loop %d, unsolved fields: %d **%n", loopCount, _board.getEmptyFields().size());

                List<Field> fields = _board.boxes.stream().flatMap(b -> b.getFields().stream()).toList();

                for (Field currFld : fields) { // inspect field by field

                    // check all remaining possible values whether one is only possible in this field
                    for (Area area : currFld.getAreas()) {
                        List<Field> otherFields = area.getFields().stream().filter(f -> f != currFld).toList();

                        // remove all values already taken by other fields
                        if (currFld.removePossibleValues(otherFields.stream().filter(Field::hasValue).map(Field::getValue).toList())) {
                            doOutput("  Solved: %s%n", currFld);
                        }

                        Set<Integer> otherPossibleValues = otherFields.stream().map(Field::getPossibleValues).flatMap(Set::stream).collect(Collectors.toSet());
                        for (int possibleValue : currFld.getPossibleValues()) {
                            if (!otherPossibleValues.contains(possibleValue)) {
                                currFld.setValue(possibleValue);
                                doOutput("  Solved: %s%n", currFld);
                                break;
                            }
                        }
                    }
                }

                // find naked pairs/triples/quads in areas
                for (Area area : _board.allAreas) {
                    for (int i = 2; i <= 6; i++) {
                        Map<Set<Integer>, List<Field>> mapOfNakedLists = area.findNakedTuples(i);
                        if (mapOfNakedLists.isEmpty()) {
                            continue;
                        }
                        for (Map.Entry<Set<Integer>, List<Field>> nakedEntry : mapOfNakedLists.entrySet()) {
                            // find empty fields not in 'naked' list and remove the naked possible values
                            Set<Integer> valuesToRemove = nakedEntry.getKey();
                            List<Field> nakedList = nakedEntry.getValue();
                            area.getFields().stream()
                                .filter(Field::isEmpty)
                                .filter(f -> !nakedList.contains(f))
                                .forEach(f -> f.getPossibleValues().removeAll(valuesToRemove));
                        }
                    }
                }

                // TODO X-Wing: https://www.sudokuwiki.org/X_Wing_Strategy

                // TODO Swordfish

                doOutput("%n");
            }

            doOutput("%s%n%n", _board);

            return _board.isSolved();
        }

        @Override
        public String toString() {
            return String.format("%s[outputEnabled=%s]", getClass().getSimpleName(), outputEnabled);
        }

    }

    public static class Board {

        private final String       name;

        private final List<Field>  allFields = new ArrayList<>(BOARD_SIZE * BOARD_SIZE);
        private final List<Row>    rows      = new ArrayList<>(BOARD_SIZE);
        private final List<Box>    boxes     = new ArrayList<>(BOARD_SIZE);
        private final List<Area>   allAreas  = new ArrayList<>(BOARD_SIZE * 3);

        public Board(String _name, char[][] _board) {
            if (_name == null) {
                throw new SudokuException("Board name cannot be null");
            }
            if (_board == null) {
                throw new SudokuException("Board cannot be null");
            }

            name = _name;

            final int rowCount = _board.length;

            // check row count is equal to size
            if (rowCount != BOARD_SIZE) {
                throw new SudokuException("Board's row count must equal " + BOARD_SIZE);
            }

            // check board is a square (number rows == number columns)
            if (Arrays.stream(_board).anyMatch(row -> row.length != rowCount)) {
                throw new SudokuException("Board's column counts must be equal to " + rowCount);
            }

            final int size = _board.length;

            Field[][] board = new Field[size][];
            for (int row = 0; row < size; row++) {
                board[row] = new Field[size];
                for (int col = 0; col < _board[row].length; col++) {
                    char cell = _board[row][col];
                    Field field = cell == '.' ? new Field() : new Field(cell - '0');
                    board[row][col] = field;
                    allFields.add(field);
                }
            }

            // populate areas

            char[] rowNames = "ABCDEFGHJ".toCharArray();
            for (int rowIdx = 0; rowIdx < size; rowIdx++) {
                rows.add(new Row(rowNames[rowIdx], Arrays.stream(board[rowIdx]).toList()));
            }

            List<Column> cols = new ArrayList<>(BOARD_SIZE);
            for (int colIdx = 0; colIdx < size; colIdx++) {
                final int finColIdx = colIdx;
                List<Field> col = java.util.stream.IntStream.range(0, size).mapToObj(i -> board[i][finColIdx]).toList();
                cols.add(new Column((char) (colIdx + 1), col));
            }

            int boxNo = 0;
            for (int rowIdx = 0; rowIdx < size; rowIdx += BOX_SIZE) {
                for (int colIdx = 0; colIdx < size; colIdx += BOX_SIZE) {
                    boxes.add(new Box((char) ++boxNo, List.of(
                        board[rowIdx][colIdx],
                        board[rowIdx][colIdx + 1],
                        board[rowIdx][colIdx + 2],
                        board[rowIdx + 1][colIdx],
                        board[rowIdx + 1][colIdx + 1],
                        board[rowIdx + 1][colIdx + 2],
                        board[rowIdx + 2][colIdx],
                        board[rowIdx + 2][colIdx + 1],
                        board[rowIdx + 2][colIdx + 2])));
                }
            }

            allAreas.addAll(rows);
            allAreas.addAll(cols);
            allAreas.addAll(boxes);
        }

        /**
         * Write the state of this board to the parameter {@code _board}.
         *
         * @param _board matrix to update
         */
        public void updateBoardMatrix(char[][] _board) {
            for (int rowIdx = 0; rowIdx < _board.length; rowIdx++) {
                List<Field> row = rows.get(rowIdx).getFields();
                for (int colIdx = 0; colIdx < _board[rowIdx].length; colIdx++) {
                    Integer val = row.get(colIdx).getValue();
                    _board[rowIdx][colIdx] = val == null ? '.' : val.toString().charAt(0);
                }
            }
        }

        public final List<Field> getFields() {
            return Collections.unmodifiableList(allFields);
        }

        public final List<Field> getEmptyFields() {
            return allFields.stream().filter(Field::isEmpty).toList();
        }

        public final boolean isSolved() {
            return getEmptyFields().isEmpty();
        }

        @Override
        public boolean equals(Object _obj) {
            if (this == _obj) {
                return true;
            } else if (_obj == null || getClass() != _obj.getClass()) {
                return false;
            }
            Board other = (Board) _obj;
            for (int i = 0; i < allFields.size(); i++) {
                if (!allFields.get(i).equals(other.allFields.get(i))) {
                    System.err.printf("Difference at index %d:%n%s%n%s%n", i, allFields.get(i), other.allFields.get(i));
                    return false;
                }

            }
            return Objects.equals(allFields, other.allFields);
        }

        @Override
        public int hashCode() {
            return Objects.hash(allFields);
        }

        @Override
        public final String toString() {
            return toString(" ");
        }

        public final String toString(String _fieldSeparator) {
            return toString(_fieldSeparator, System.lineSeparator());
        }

        public final String toString(String _fieldSeparator, String _lineSeparator) {
            String fieldSeparator = Optional.ofNullable(_fieldSeparator).orElse(" ");
            String lineSeparator = Optional.ofNullable(_lineSeparator).orElse(System.lineSeparator());
            return String.format("%s['%s', %s]%s%s",
                getClass().getSimpleName(), name, isSolved() ? "solved" : "NOT SOLVED", lineSeparator,
                rows.stream().map(r -> r.toString(fieldSeparator)).collect(Collectors.joining(lineSeparator)));
        }

    }

    /**
     * A row, column or box holding exactly 9 values.
     */
    abstract static class Area {
        private final char          itemNo;
        @SuppressWarnings("checkstyle:VisibilityModifierCheck")
        protected final List<Field> fields = new ArrayList<>(BOARD_SIZE);

        Area(char _itemNo, Collection<Field> _fields) {
            itemNo = _itemNo;
            if (_fields == null || _fields.size() != BOARD_SIZE) {
                throw new SudokuException(BOARD_SIZE + " values required");
            } else {
                List<Field> nonNullValues = _fields.stream().filter(Field::hasValue).toList();
                if (nonNullValues.size() != new HashSet<>(nonNullValues).size()) {
                    throw new SudokuException("Values contain duplicates in " + getClass().getSimpleName() + " " + getItemNo() + ": " + _fields);
                }
            }

            @SuppressWarnings("unchecked")
            Class<Area> clazz = (Class<Area>) getClass();
            _fields.forEach(f -> {
                f.setArea(clazz, this);
                fields.add(f);
            });

        }

        public final char getItemNo() {
            return itemNo;
        }

        public final List<Field> getFields() {
            return new ArrayList<>(fields);
        }

        public final Map<Set<Integer>, List<Field>> findNakedTuples(int _count) {
            if (_count < 2 || _count > 8) {
                throw new SudokuException("Invalid naked count");
            }

            Map<Set<Integer>, List<Field>> results = new HashMap<>();

            Stream<Field> filtered = fields.stream()
                .filter(Field::isEmpty)
                .filter(f -> f.getPossibleValues().size() <= _count);
            List<Field> preCandidates = filtered.toList();

            Map<Integer, Map<Set<Integer>, List<Field>>> groups = preCandidates.stream()
                .collect(Collectors.groupingBy(t -> t.getPossibleValues().size(), Collectors.groupingBy(Field::getPossibleValues)));
            for (int i = _count; i >= 2; i--) {
                Map<Set<Integer>, List<Field>> fieldsBySamePossVals = groups.get(i);
                if (fieldsBySamePossVals == null) {
                    continue;
                }
                for (List<Field> fieldListSamePossVals : fieldsBySamePossVals.values()) {
                    Set<Integer> upperPossVals = fieldListSamePossVals.get(0).getPossibleValues();
                    results.put(upperPossVals, new ArrayList<>());
                    for (int j = i; j >= 2; j--) {
                        Map<Set<Integer>, List<Field>> fieldsByLessSamePossVals = groups.get(j);
                        if (fieldsByLessSamePossVals == null) {
                            continue;
                        }
                        for (Map.Entry<Set<Integer>, List<Field>> eLessSamePossVals : fieldsByLessSamePossVals.entrySet()) {
                            if (upperPossVals.containsAll(eLessSamePossVals.getKey())) {
                                results.get(upperPossVals).addAll(eLessSamePossVals.getValue());
                            }
                        }
                    }
                }
            }

            if (!results.isEmpty()) {
                // leave only lists of fields with length >= possible values
                Map<Set<Integer>, List<Field>> filteredResults = results.entrySet().stream()
                    .filter(e -> e.getValue().size() >= e.getKey().size())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                if (!filteredResults.isEmpty()) {
                    return filteredResults;
                }
            }

            return Map.of();
        }

        public final List<Integer> getValues() {
            return fields.stream().filter(Field::hasValue).map(Field::getValue).toList();
        }

        @Override
        public final String toString() {
            return toString(" ");
        }

        String toString(String _separator) {
            return fields.stream().map(Field::toShortString).collect(Collectors.joining(_separator));
        }
    }

    /**
     * One of the nine rows in the Sudoku playing field.
     */
    static class Row extends Area {
        Row(char _itemNo, Collection<Field> _values) {
            super(_itemNo, _values);
        }
    }

    /**
     * One of the nine columns in the Sudoku playing field.
     */
    static class Column extends Area {
        Column(char _itemNo, Collection<Field> _values) {
            super(_itemNo, _values);
        }
    }

    /**
     * One of the nine 3x3 areas in the Sudoku playing field.
     */
    static class Box extends Area {
        Box(char _itemNo, Collection<Field> _values) {
            super(_itemNo, _values);
        }
    }

    public static final class Field {
        private Integer                                value;
        private final Map<Class<? extends Area>, Area> areas          = new LinkedHashMap<>();
        /** List of possible values. Empty if value present. */
        private final Set<Integer>                     possibleValues = new LinkedHashSet<>();

        Field() {
            this(null);
        }

        Field(Integer _value) {
            if (_value == null) {
                possibleValues.addAll(java.util.stream.IntStream.rangeClosed(1, BOARD_SIZE).boxed().toList());
            } else {
                value = requireValue(_value);
            }
        }

        static Integer requireValue(Integer _value) {
            if (_value == null || _value < 1 || _value > BOARD_SIZE) {
                throw new SudokuException("Invalid value: " + _value);
            }
            return _value;
        }

        <T extends Area> void setArea(Class<T> _class, T _sudokuArea) {
            if (areas.containsKey(_class)) {
                throw new SudokuException(_class.getSimpleName() + " already set: " + areas.get(_class));
            }
            areas.put(_class, _sudokuArea);
        }

        @SuppressWarnings("unchecked")
        <T extends Area> T getArea(Class<T> _class) {
            return (T) areas.get(_class);
        }

        List<Area> getAreas() {
            return areas.values().stream().toList();
        }

        int getColNo() {
            return getArea(Column.class).getItemNo();
        }

        char getRowNo() {
            return getArea(Row.class).getItemNo();
        }

        int getBoxNo() {
            return getArea(Box.class).getItemNo();
        }

        public Integer getValue() {
            return value;
        }

        public boolean hasValue() {
            return value != null;
        }

        public boolean isEmpty() {
            return value == null;
        }

        public Set<Integer> getPossibleValues() {
            return possibleValues;
        }

        public boolean removePossibleValues(Collection<Integer> _possibleValues) {
            possibleValues.removeAll(_possibleValues);
            if (possibleValues.size() == 1) {
                setValue(possibleValues.iterator().next());
                return true;
            }
            return false;
        }

        public void setValue(Integer _value) {
            value = requireValue(_value);
            possibleValues.clear();
        }

        @Override
        public boolean equals(Object _obj) {
            if (this == _obj) {
                return true;
            } else if (_obj == null || getClass() != _obj.getClass()) {
                return false;
            }
            Field other = (Field) _obj;
            boolean equals = Objects.equals(value, other.value);
            if (equals) {
                equals = Objects.equals(areas.values().stream().map(Area::getItemNo).toList(),
                    other.areas.values().stream().map(Area::getItemNo).toList());
            }
            return equals;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, areas);
        }

        @Override
        public String toString() {
            if (hasValue()) {
                return String.format("Field[%s%s box=%s, val=%d]", getRowNo(), getColNo(), getBoxNo(), value);
            } else {
                return String.format("Field[%s%s box=%s, possible=%s]", getRowNo(), getColNo(), getBoxNo(), possibleValues.stream().map(i -> i + "").collect(Collectors.joining(",")));
            }
        }

        public String toShortString() {
            return value == null ? "." : Integer.toString(value);
        }

    }

    public static final class AsciiBoard {

        public static String draw(Board _board) {
            return draw(_board, null);
        }

        public static String draw(Board _board, String _lineSeparator) {
            String lineSeparator = Optional.ofNullable(_lineSeparator).orElse(System.lineSeparator());

            StringBuilder sb = new StringBuilder();
            int nbRows = _board.rows.size();

            for (int rowIdx = 0; rowIdx < nbRows; rowIdx++) {
                Sudoku.Row row = _board.rows.get(rowIdx);

                if (rowIdx == 0) {
                    String colNos = "   " + row.getFields().stream().map(Field::getColNo).map(i -> "  " + i + "   ").collect(Collectors.joining(""));
                    sb.append(colNos)
                        .append(lineSeparator)
                        .append("  ┌─────")
                        .append("┬─────".repeat(8))
                        .append("┐")
                        .append(lineSeparator);
                }

                sb.append("  │     ")
                    .append("│     ".repeat(8))
                    .append("│")
                    .append(lineSeparator)

                    .append(row.getItemNo())
                    .append(" ");

                for (int colIdx = 0; colIdx < row.getFields().size(); colIdx++) {
                    Sudoku.Field fld = row.getFields().get(colIdx);

                    if (fld.getValue() == null) {
                        sb.append("│     ");
                    } else {
                        sb.append("│ -")
                            .append(fld.getValue())
                            .append("- ");
                    }

                }
                sb.append("│")
                    .append(lineSeparator)

                    .append("  │     ")
                    .append("│     ".repeat(8))
                    .append("│")
                    .append(lineSeparator);

                if (rowIdx < nbRows - 1) {
                    sb.append("  ├─────")
                        .append("┼─────".repeat(8))
                        .append("┤")
                        .append(lineSeparator);
                }

            }

            sb.append("  └─────")
                .append("┴─────".repeat(8))
                .append("┘")
                .append(lineSeparator);

            return sb.toString();
        }
    }

    public static class SudokuException extends RuntimeException {
        private static final long serialVersionUID = 1L;

        public SudokuException(String _message) {
            super(_message);
        }

    }

}
