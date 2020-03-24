# EMS
This is an event management system created by Enfec back-end developers. The whole system covers 3 user types: customer/organizer/admin. Customer can use this website to search any ongoing events, choose seats and place tickets orders; Organizer can place venue orders and post event information; Admin can help both organizers and customers resolve user issues. 

## Event Service

+ **../event/search?event_id=1**\
       Search event by event_id, this should be only accessed by admin.  

+ **../event/search/{anything}**\
       Search events by anything exclude id information, this should be used for filtered bar. 
       
+ **../event/search/by_date?start_date=2020-07-01&end_date=2020-08-01&zipcode=98061&event_type=concert**\
       Search events within a date range with zipcode or event_type 

+ **../event/create**\
       Create an event by organizer or admin

+ **../event/update**\
       Update an event by organizer or admin 
       
+ **../event/delete/{Event_ID}**\
       Delete an event by organizer or admin
