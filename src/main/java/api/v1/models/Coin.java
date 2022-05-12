package api.v1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Coin {
    private String date;
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