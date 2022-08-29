package ru.practicum;

public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

//        старый вариант без регулярок
//        final int MIN_NUMBER_OF_CHARS_IN_NAME = 3;
//        final int MAX_NUMBER_OF_CHARS_IN_NAME = 19;
//        boolean isValidStringLength = (name.length() >= MIN_NUMBER_OF_CHARS_IN_NAME) && (name.length() <= MAX_NUMBER_OF_CHARS_IN_NAME);
//        boolean isInvalidSpacePlacement = name.startsWith(" ") || name.endsWith(" ");
//        int spaceCount = name.length() - name.replace(" ", "").length();
//
//        if ((name != null) && (isValidStringLength) && (!isInvalidSpacePlacement) && (spaceCount == 1)) {
//            return true;
//        } if else {
//            return false;
//        }

        // проверка через регулярку
        if (this.name == null) {
            return false;
        }

        return name.matches("(?=.{3,19}$)[а-яА-Яa-zA-Z0-9]+ [а-яА-Яa-zA-Z0-9]+");
    }
}
