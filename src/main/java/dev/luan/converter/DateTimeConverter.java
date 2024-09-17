package dev.luan.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeConverter {

    private Date date;

    public DateTimeConverter(String dateStr) throws Exception {
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.date = isoFormat.parse(dateStr);
    }

    public String toIso8601() {
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return isoFormat.format(date);
    }

    public String toIso9075() {
        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return isoFormat.format(date);
    }

    public String toRfc3339() {
        SimpleDateFormat rfcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        return rfcFormat.format(date);
    }

    public String toRfc7231() {
        SimpleDateFormat rfcFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
        return rfcFormat.format(date);
    }

    public long toUnixTimestamp() {
        return date.getTime() / 1000;
    }

    public long toTimestamp() {
        return date.getTime();
    }

    public String toUtcFormat() {
        SimpleDateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return utcFormat.format(date);
    }

    public String toMongoObjectId() {
        long timestamp = date.getTime() / 1000;
        return Long.toHexString(timestamp) + "0000000000000000";
    }

    public double toExcelDate() {
        long timestamp = date.getTime();
        return timestamp / (24 * 60 * 60 * 1000) + 25569;
    }
}
