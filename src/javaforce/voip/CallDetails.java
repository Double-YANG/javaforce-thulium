package javaforce.voip;

/**
 * Keeps track of Call Details based on the 'callid' field of SIP messages.
 */

import java.util.*;

import java.net.*;

public class CallDetails implements Cloneable {

  /**
   * Every call has 2 sides, originator and terminator.
   * This class keeps track of each side.
   */
  public static class SideDetails implements Cloneable {
    public int cseq = 0;
    public int expires = 0;
    public String to[], from[];  //0=name < 1=# 2=host/port ... > ':' ...
    public String uri;
    public String contact;
    public String vialist[];
    public String branch;
    public String extra;   //extra headers
    public String epass;   //response to an 403/407 MD5
    public long o1, o2;
    public SDP sdp;  //sdp as decoded from inbound packets
    public String host;
    public InetAddress addr;
    public int port;
    public Object clone() {
      try {
        return super.clone();
      } catch (Exception e) {
        return null;
      }
    }
  };
  /** Keeps track of src side (caller) */
  public SideDetails src = new SideDetails();
  /** Keeps track of dst side (callee) */
  public SideDetails dst = new SideDetails();
  /** unique id for this call leg (not caller ID) */
  public String callid;
  /** sdp content to be added to outbound packets */
  public String sdp;
  /** Authorization string */
  public String authstr;
  /** was auth (401/407) tried? */
  public boolean authsent;
  /** last set of full headers received. */
  public String headers[];
  public Object clone() {
    try {
      return super.clone();
    } catch (Exception e) {
      return null;
    }
  }
}
