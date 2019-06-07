package com.Bookeater.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Category {

    private String Cid;
    private String Cname;

    public String getCid() { return Cid; }
    public void setCid(String cid) { this.Cid = cid; }

    public String getCname() { return Cname; }
    public void setCname(String cname) { this.Cname = cname; }
}
