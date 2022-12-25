package Setting;

public class ValidateSetting {
    public static String validateString(String needsValidate) {
        if (needsValidate != null && !needsValidate.isEmpty() && !needsValidate.isBlank()) {
            return needsValidate;
        } else {
            throw new RuntimeException("Введены не допустимые значения названия ");
        }
    }


    public static void validateDate (String date) throws WrongDateException {
        date = date.trim();
        if (date.matches("\\d{2}\\/\\d{2}\\/\\d{4}")) {
            return;
        } else {
            throw new WrongDateException("Дата введена не правильно:" + date);
        }
    }

    public static Periodicity validatePeriodicity(int s) {
        Periodicity periodicity = null;
        switch (s) {
            case 1:
                periodicity = Periodicity.ONE_TIME;
                break;
            case 2:
                periodicity = Periodicity.DAILY;
                break;
            case 3:
                periodicity = Periodicity.WEEKLY;
                break;
            case 4:
                periodicity = Periodicity.MONTHLY;
                break;
            case 5:
                periodicity = Periodicity.YEARLY;
                break;
        }
        if (periodicity == null) {
            throw new RuntimeException("Признак повторяемости задачи введен неккоректно");
        } else {
            return periodicity;
        }
    }

    public static boolean validateIsWork(int s) {
        return s==1;
    }
}
