public class Time extends Applet
    {

    // instantiate a label to write on
    private Label label = new Label("hi there");
    // variable stop is used to stop the while loop in the Thread
    private boolean stop = false;
    // a calendar reference for displaying the time and date
    private GregorianCalendar calendar = null;
    // an object to control the format inwhich the time and date is displayed
    private SimpleDateFormat dateFormat = new SimpleDateFormat(" hh:mm:ss  dd - MM - yyyy");


    public void init()
        {
           calendar = new GregorianCalendar();

            label.setFont(new Font("Arial",Font.PLAIN,20));
            this.add(label);
        }

    // start method with a new Thread instantiated

    public void start()
        {
            stop = false;

            // instantiate a new Thread and override the run method
            Thread t = new Thread(){

                
                    public void run() {

                        while(!stop)
                        {
                            // create a delay of 500 milliseconds
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException ex) { }

                            calendar.setTimeInMillis(System.currentTimeMillis());

                            label.setText(dateFormat.format(calendar.getTime()));

                        }
                    }
            };

            // start the new Thread
            t.start();
        }

    public void stop()
        {
            stop = true;
        }
    }
    