# stock-quote-manager

Stock Quote Manager is a Rest CRUD aplication  that the user can:<br/>
&nbsp;&nbsp;&nbsp;• Create a Stock Quote<br/>
&nbsp;&nbsp;&nbsp;• Read a Stock Quote by id<br/>
&nbsp;&nbsp;&nbsp;• Read all Stock Quotes <br/>

First the User need to ADD a Stock id at http://localhost:8081/stock using HTTP Request POST using the followin JSON:<br/>
{<br/>
 &nbsp;&nbsp;&nbsp;   "id" : "StockID"  <br/>
}<br/>

You can ADD as many as you want.<br/>

Then he/she can add Quotes do this Stock at http://localhost:8081/quote POST Request, using the Stock ID registered before example:<br/>
{<br/>
&nbsp;&nbsp;&nbsp; 	"quoteDate": "04/01/2021",<br/>
&nbsp;&nbsp;&nbsp;	"quoteValue": 50.00,<br/>
	&nbsp;&nbsp;&nbsp; "stock" : {<br/>
   &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;     "id" : "StockID"<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    } <br/> 
}<br/>

After the registrations the user can see the information put together using http://localhost:8081/stock  GET Request:<br/>
    {<br/>
 &nbsp;&nbsp;&nbsp;       "id": "stockid",<br/>
 &nbsp;&nbsp;&nbsp;       "quotes": {<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            "04/01/2021": 50.0,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            "03/01/2021": 40.0,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            "02/01/2021": 30.0<br/>
&nbsp;&nbsp;&nbsp;        }<br/>
    },<br/>
    {<br/>
 &nbsp;&nbsp;&nbsp;       "id": "stockid2",<br/>
&nbsp;&nbsp;&nbsp;        "quotes": {<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;            "05/01/2021": 50.0<br/>
&nbsp;&nbsp;&nbsp;        }<br/>
    }<br/>
As well as finding the Stocks by ID using http://localhost:8081/stock/<id> GET Request <br/>
<br/>
ID choosen "stockid"<br/>
{<br/>
&nbsp;&nbsp;&nbsp;    "id": "stockid",<br/>
&nbsp;&nbsp;&nbsp;    "quotes": {<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        "04/01/2021": 50.0,<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;        "03/01/2021": 40.0,<br/>
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;       "02/01/2021": 30.0<br/>
  &nbsp;&nbsp;&nbsp;  }<br/>
}<br/>
<br/>
The Date and Value are registered separeted but the algorithm put then together in a HashMap and give the response back to User.<br/>
