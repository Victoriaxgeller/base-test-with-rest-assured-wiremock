package api.common;

import lombok.*;

import java.util.Map;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestBuilder {

    public String path;
    private String pathParamName;
    private String pathParamValue;
    private Map<String, String> headers;
    private Map<String, String> queryParameters;
    private Map<String, String> pathParams;
    private String body;

}
