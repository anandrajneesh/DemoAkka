package com.akka.chap01;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class HelloWorld extends UntypedActor{

	@Override
	public void onReceive(Object arg0) throws Exception {
		if(arg0 == Greeter.Msg.DONE){
			getContext().stop(getSelf());
		}else{
			unhandled(arg0);
		}
	}
	
	@Override
	public void preStart() throws Exception {
		ActorRef greeter = getContext().actorOf(Props.create(Greeter.class));
		greeter.tell(Greeter.Msg.GREET, getSelf());
	}

}
