package req.specification;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestBuilder {

    private String relativePath;
    private String pathParamName;
    private String pathParamValue;


    public RequestBuilder setRelativePath(String relativePath) {
        this.relativePath = relativePath;
        return this;
    }

    public RequestBuilder setPathParamName(String pathParamName) {
        this.pathParamName = pathParamName;
        return this;
    }


    public RequestBuilder setPathParamValue(String pathParamValue) {
        this.pathParamValue = pathParamValue;
        return this;
    }

}
