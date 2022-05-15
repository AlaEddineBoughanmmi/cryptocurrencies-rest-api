package api.v1.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coin {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
    private String unadjustedVolume;
    private String change;
    private String changePercent;
    private String vwap;
    private String label;
    private String changeOverTime;
}