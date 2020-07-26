package org.acme.composite.model;

import org.acme.kogito.model.Request;
import java.util.Map;

public class CaseRequest {
    public Request request;
    public String id;
    public Map<String,String> tasks;
}