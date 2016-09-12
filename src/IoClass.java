import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class IoClass
{
    public static void main (String[] args) throws java.lang.Exception
    {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int calcTime = Integer.parseInt(br.readLine());
     
        final List<Event> list = new LinkedList<Event>();
        String input;
        do{
        	input = br.readLine();
            String [] split = input.trim().split(" ");

            Event event = new Event();
            event.time = Integer.parseInt(split[0]);
            event.type = split[1];
            list.add(event);
         
        } while ((input = br.readLine())!=null) ;

        System.out.println(numberOfCarsInGarageAtTime(list,calcTime));


    }

    public static int numberOfCarsInGarageAtTime(List<Event> events, int time) {
    	int numIn =1, numOut =1;
     for(Event e: events){
    	 if(e.time <=time && e.type.equalsIgnoreCase("IN")){
    		 numIn++;
    	 }
    	 else if(e.time <=time && e.type.equalsIgnoreCase("OUT")){
    		 numOut++;
    	 }
     }
     return numIn-numOut;
    }

  static  class Event{

        public int time;
        public String type;
    }
}
