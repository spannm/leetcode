package io.github.spannm.leetcode.lc1.lc1500;

import io.github.spannm.leetcode.LeetcodeProblem;

class Problem1507 extends LeetcodeProblem {

    String reformatDate(String _date) {
        String[] dates = _date.split(" ");
        return dates[2] + "-" + getMonth(dates[1]) + "-" + getDay(dates[0]);
    }

    private static String getDay(String _day) {
        String formatedDay = _day.substring(0, _day.length() - 2);
        if (formatedDay.length() == 1) {
            return "0" + formatedDay;
        }
        return formatedDay;
    }

    private static String getMonth(String _month) {
        return switch (_month) {
            case "Jan" -> "01";
            case "Feb" -> "02";
            case "Mar" -> "03";
            case "Apr" -> "04";
            case "May" -> "05";
            case "Jun" -> "06";
            case "Jul" -> "07";
            case "Aug" -> "08";
            case "Sep" -> "09";
            case "Oct" -> "10";
            case "Nov" -> "11";
            case "Dec" -> "12";
            default -> "";
        };
    }

}
