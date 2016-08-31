<%@ page import="date_tests.DateStore" %>


<div class="fieldcontain ${hasErrors(bean: dateStoreInstance, field: 'fromClient', 'error')}">
	<label for="fromClient">
		<g:message code="dateStore.fromClient.label" default="From Client" />
		<span class="required-indicator">*</span>
	</label>
   
   <input name="fromClient" value="${dateStoreInstance?.fromClient}" size="80" />
</div>
<div class="fieldcontain ${hasErrors(bean: dateStoreInstance, field: 'toUTC', 'error')}">
	<label for="toUTC">
		<g:message code="dateStore.toUTC.label" default="To UTC" />
		<span class="required-indicator">*</span>
	</label>
   
	<input name="toUTC" value="${dateStoreInstance?.toUTC}" size="80" />
</div>
<div class="fieldcontain ${hasErrors(bean: dateStoreInstance, field: 'fromClientUTC', 'error')}">
	<label for="fromClientUTC">
		<g:message code="dateStore.fromClientUTC.label" default="From Client UTC" />
		<span class="required-indicator">*</span>
	</label>
   
	<input name="fromClientUTC" value="${dateStoreInstance?.fromClientUTC}" size="80" />
</div>


<div class="fieldcontain">
  <label for="tzOffset">Client timezone Offset:</label>
  <input name="tzOffset" value="" size="80" />
  <br/>
  <i>Add this to the date to make it UTC.</i>
</div>

<script>
  /*
  Date formatted in the local time of the client.
  */
  function toLocal (date) {
	var local = new Date(date);
	local.setMinutes(date.getMinutes() - date.getTimezoneOffset());
	return local.toISOString().slice(0, -1) + tzSting(date.getTimezoneOffset()); // slice removes Z
  }
  function tzSting(offset)
  {
     var offsetMinutesHours = Math.floor( offset / 60 ); // Check juts hours, offset can be 2.5 houts (150 minutes)
  
     var res = '';
     if (offsetMinutesHours > 0)
     {
        res += '-';
     }
     else
     {
        rest += '+';
     }
     
     var val = Math.abs(offsetMinutesHours);
     if (val < 10)
     {
        res += '0';
     }
     res += val; // + ':'; // without : is the RFC 822 time zone, ISO 8601 supports -08; -0800; -08:00
     
     // now the minutes of the tz
     
     // the offset was a multiple of an hour, no minutes
     if (offsetMinutesHours * 60 == offset)
     {
        res += '00';
     }
     else
     {
        var minutes = offset - (offsetMinutesHours * 60);
        if (minutes < 10)
        {
           res += '0';
        }
        res += minutes;
     }
     
     return res;
  }

  var d = new Date();
  
  // client timezone offset
  var tzOffsetInput = document.getElementsByName("tzOffset")[0];
  tzOffsetInput.value = d.getTimezoneOffset() / 60;
  
  var fromClientInput = document.getElementsByName("fromClient")[0];
  fromClientInput.value = toLocal(d);
  
  /*
  var fromClientInput = document.getElementsByName("toUTC")[0];
  fromClientInput.value = d.toISOString();
  */
  
  var fromClientInput = document.getElementsByName("fromClientUTC")[0];
  fromClientInput.value = d.toISOString();  // transformed to UTC in the client
</script>
