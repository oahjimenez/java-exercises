# Key reminders
* Single producer instance, single consumer instance
* Data is shared through a single monitor instance. This instance serves as lock resource to synchronize reads and writes between the producer and consumer
* Once monitor lock is acquired by a Thread (either producer or consumer), remaining Threads are blocked (list of blocked Threads waiting for the resource to be released)
* wait -> causes the Thread to shift to WAITING state, releasing the monitor resource
* notify -> releases the lock on the resource
* If there were to be more competing threads => Wrap the wait in a while condition + use notifyAll to prevent dead locks
* synchronized method -> lock on the instance calling the method
