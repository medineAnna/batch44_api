package pojos;

import pojo.DummyPojo01;

import java.util.List;

public class DummyResponsePojo {



    private String status;
    private List<DummyPojo01> data;
    private String message;


    @Override
    public String toString() {
        return "DummyResponsePojo{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", message='" + message + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DummyPojo01> getData() {
        return data;
    }

    public void setData(List<DummyPojo01> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DummyResponsePojo() {
    }

    public DummyResponsePojo(String status, List<DummyPojo01> data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
}