package Daily;

/**
 * @author Jacob
 * @creator 2022/1/3-11:42
 */
public class Test1185 {
    public static String dayOfTheWeek(int day, int month, int year) {
        int y = year - 1971;
        int d = y * 365;
        if(y >= 2){
            d += (y - 2) / 4 + 1;
        }
        switch(month){
            case 12:    d += 30;
            case 11:    d += 31;
            case 10:    d += 30;
            case 9:    d += 31;
            case 8:    d += 31;
            case 7:    d += 30;
            case 6:    d += 31;
            case 5:    d += 30;
            case 4:    d += 31;
            case 3:{
                d += 28;
                if(((year % 4 == 0)&&(year % 100 != 0))||((year % 100 == 0)&&(year % 400 == 0)))
                    d += 1;
            }
            case 2:    d += 31;
            case 1:    d += day;
        }
        System.out.println(d);

        String s = "";
        switch((d-1) % 7){
            case 0: {
                s = "Friday";
                break;
            }
            case 1: {
                s = "Saturday";
                break;
            }
            case 2: {
                s = "Sunday";
                break;

            }
            case 3: {
                s = "Monday";
                break;

            }
            case 4: {
                s = "Tuesday";
                break;

            }
            case 5: {
                s = "Wednesday";
                break;

            }
            case 6: {
                s = "Thursday";
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int day = 31;
        int month = 8;
        int year = 2019;
        String s = dayOfTheWeek(day, month, year);
        System.out.println(s);
//        System.out.println(-2/4);
    }
}
