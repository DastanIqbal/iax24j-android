package com.example.iax24j_android;

import iax.client.audio.AudioFactory;
import iax.client.audio.impl.NullAudioFactory;
import iax.client.protocol.call.Call;
import iax.client.protocol.peer.Peer;
import iax.client.protocol.peer.PeerListener;
import iax.client.protocol.user.command.NewCall;
import iax.client.protocol.user.command.UserCommandFacade;

 
/**
 *
 * @author john
 */
public class iaxConnection implements PeerListener {
    public static Peer mypeer;
    public static boolean registered = false;
    
    public void hungup(String calledNumber) {}

    public void recvCall(String callingName, String callingNumber) {
        System.out.println("New Call From: " + callingNumber);
    }

    public void registered() {
        System.out.println("Registered");
        registered = true;
    }
        
    public void waiting() {
        System.out.println("Wating");
    }

    public void unregistered() {}

    public void exited() {
        System.out.println("Exited");
    }

    public void answered(String calledNumber) {}

    public void playWaitTones(String calledNumber) {}      
    
    /** Creates a new instance of iaxConnection */
    public iaxConnection() {
    }
    
    public void connect() {
        mypeer = new Peer(this,"201","q1kdid93","90.189.119.84",14570, true,1);
        System.out.println(mypeer.getState());
 
    }
    public void call(String number) {
        try {
            if (registered) {                
                //NewCall call = new NewCall(mypeer,number);
                //call.execute();
                //NullAudioFactory aFactory= new NullAudioFactory();
                //Call c = new Call(mypeer,201, aFactory);
                //c.startCall(number);
                UserCommandFacade.newCall(mypeer, number);
                
                
            } else {
                System.out.println("Not Registered: " + mypeer.getState());
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public boolean isEnabled() {

		return false;
	}

}