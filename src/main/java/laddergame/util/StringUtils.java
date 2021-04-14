package laddergame.util;

import laddergame.domain.ladder.Line;

public class StringUtils {
    public static final int NAME_WIDTH = 5;
    public static final String SPACE = " ";
    public static final String LINK = "-----";
    public static final String NOT_LINK = "     ";
    public static final String LINE_POINT = "|";


    public static String fitName(String name) {
        StringBuilder fit = new StringBuilder();
        while (fit.length() + name.length() < NAME_WIDTH - 1) {
            fit.append(SPACE);
        }
        fit.append(name);
        if (name.length() < NAME_WIDTH) {
            fit.append(SPACE);
        }
        return fit.toString();
    }

    public static String fitLine(Line line) {
        StringBuilder fit = new StringBuilder();
        line.isConnect().stream()
                .forEach(connected -> fitConnect(connected, fit));
        return fit.toString();
    }

    private static StringBuilder fitConnect(Boolean connected, StringBuilder fit) {
        if (connected) {
            fit.append(LINK + LINE_POINT);
            return fit;
        }
        fit.append(NOT_LINK + LINE_POINT);
        return fit;
    }
}
