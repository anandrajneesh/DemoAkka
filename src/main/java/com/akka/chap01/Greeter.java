package com.akka.chap01;

import akka.actor.UntypedActor;

public class Greeter extends UntypedActor {

	public enum Msg{
		GREET , DONE;
	}
	@Override
	public void onReceive(Object arg0) throws Exception {

		if(arg0 == Msg.GREET){
			System.out.println("so what say?");
			getSender().tell(Msg.DONE, getSelf());
			
		}
		else{
			unhandled(arg0);
		}
	}

}
