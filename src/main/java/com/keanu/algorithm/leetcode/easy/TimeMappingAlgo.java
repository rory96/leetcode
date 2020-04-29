package com.keanu.algorithm.leetcode.easy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeMappingAlgo {

    public static Map<String, Integer> calculate(LocalDateTime start, LocalDateTime end) {
        if (start.compareTo(end) > 0) {
            return nightWork(start, end);
        }
        return dayWork(start, end);
    }
    private static Map<String, Integer> dayWork(LocalDateTime start, LocalDateTime end) {
        Map<String, Integer> map = new HashMap<>();
        map.put(TimeMapping.values()[start.getHour()].text, 60 - start.getMinute());
        map.put(TimeMapping.values()[end.getHour()].text, end.getMinute());
        for (int i = 0; i < 24; i++) {
            if (i == start.getHour() || i == end.getHour()) continue;
            if (i > start.getHour() && i < end.getHour()) {
                map.put(TimeMapping.values()[i].text, 60);
            } else {
                map.put(TimeMapping.values()[i].text, 0);
            }
        }
        return map;
    }

    private static Map<String, Integer> nightWork(LocalDateTime start, LocalDateTime end) {
        Map<String, Integer> map = new HashMap<>();
        map.put(TimeMapping.values()[start.getHour()].text, 60 - start.getMinute());
        map.put(TimeMapping.values()[end.getHour()].text, end.getMinute());
        for (int i = start.getHour() + 1; i < 24; i++) {
            map.put(TimeMapping.values()[i].text, 60);
        }
        for (int j = 0; j < start.getHour(); j++) {
            if (j == end.getHour()) continue;
            if (j < end.getHour()) {
                map.put(TimeMapping.values()[j].text, 60);
            }  else {
                map.put(TimeMapping.values()[j].text, 0);
            }
        }
        return map;
    }

    public static void main(String[] args) {
//        List<LocalDateTime> times = new ArrayList<>();
//        times.add(LocalDateTime.parse("2019-10-12T10:40:22"));
//        times.add(LocalDateTime.parse("2019-10-12T22:20:22"));
        LocalDateTime start = LocalDateTime.parse("2019-10-12T20:50:22");
        LocalDateTime end = LocalDateTime.parse("2019-10-12T07:30:22");
        System.out.println(String.format("start: %s", start.toString()));
        System.out.println(String.format("end: %s", end.toString()));
        Map<String, Integer> map = calculate(start, end);
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(String.format("%s : %s", e.getKey(), e.getValue()));
        }
    }


    enum TimeMapping {
        H00(0, "00:00 - 01:00"),
        H01(1, "01:00 - 02:00"),
        H02(2, "02:00 - 03:00"),
        H03(3, "03:00 - 04:00"),
        H04(4, "04:00 - 05:00"),
        H05(5, "05:00 - 06:00"),
        H06(6, "06:00 - 07:00"),
        H07(7, "07:00 - 08:00"),
        H08(8, "08:00 - 09:00"),
        H09(9, "09:00 - 10:00"),
        H10(10, "10:00 - 11:00"),
        H11(11, "11:00 - 12:00"),
        H12(12, "12:00 - 13:00"),
        H13(13, "13:00 - 14:00"),
        H14(14, "14:00 - 15:00"),
        H15(15, "15:00 - 16:00"),
        H16(16, "16:00 - 17:00"),
        H17(17, "17:00 - 18:00"),
        H18(18, "18:00 - 19:00"),
        H19(19, "19:00 - 20:00"),
        H20(20, "20:00 - 21:00"),
        H21(21, "21:00 - 22:00"),
        H22(22, "22:00 - 23:00"),
        H23(23, "23:00 - 24:00");

        int hour;
        String text;
        TimeMapping(int hour, String text) {
            this.hour = hour;
            this.text = text;
        }
    }
}
