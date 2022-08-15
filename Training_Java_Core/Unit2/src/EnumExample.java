import java.util.Calendar;
import java.util.Locale;

public class EnumExample {
    public enum VnDay{
        THU_HAI, THU_BA, THU_TU, THU_NAM, THU_SAU, THU_BAY, CHU_NHAT, KHONG_BIET;

        public static VnDay valueOf(Calendar calendar) {
            Locale locale = new Locale("vi");
            String type = calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, locale);
            switch (type) {
                case "Th 2":
                    return VnDay.THU_HAI;
                case "Th 3":
                    return VnDay.THU_BA;
                case "Th 4":
                    return VnDay.THU_TU;
                case "Th 5":
                    return VnDay.THU_NAM;
                case "Th 6":
                    return VnDay.THU_SAU;
                case "Th 7":
                    return VnDay.THU_BAY;
                case "CN":
                    return VnDay.CHU_NHAT;
            }
            return VnDay.KHONG_BIET;
        }
    }

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("Hom nay la: "+EnumExample.VnDay.valueOf(calendar));
    }
}


