<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="header_text">Contact Us</div>
<div class="contactUsWestSide">
	<header id="contactUsHeaderContainer"> MAIL US </header>
	<s:if test="hasActionErrors()">
				<div class="email_message email_error">
					<s:actionerror/>
				</div>
			</s:if>
			<s:if test="hasActionMessages()">
				<div class="email_message email_sent">
					<s:actionmessage/>
				</div>
	</s:if>
	 <form id="update" class="smallForm" action="sendEmail">
		<div id="customerInfoContainer">
				<input type="text" name="name" value="* Name:" onfocus="if (this.value == '* Name:') {this.value = '';}" onblur="if (this.value == '') {this.value = '* Name:';}"/>
				<br/><br/>
				<input type="text" name="email" value="* Email:" onfocus="if (this.value == '* Email:') {this.value = '';}" onblur="if (this.value == '') {this.value = '* Email:';}"/>
				<br/><br/>
				<input type="text" name="contactNumber" value="* Contact Number:" onfocus="if (this.value == '* Contact Number:') {this.value = '';}" onblur="if (this.value == '') {this.value = '* Contact Number:';}"/>
				<br/><br/>
		</div>
	
		<div id="customerInfoComments">
			<div>Questions or Comments *</div>
			<div>
				<textarea name="questionsAndComments" rows="10" cols="45"></textarea>
			</div>
		</div>
	
		<div id="submitButton">
			<input type="submit" value="Submit" class="button">
		</div>
	</form>
</div>

<div class="contactUsEastSide">
		
		
	<br/>
	
			<p>If you would like to know the prices of our
		products and know more about Tea-Pop, please contact us at (033)
		376-4323. 
		<br/>
		Thank You!</p>
		
	
	
	
	<div id="" class="small_infobox">
	
		<img class="locationIcon iconLeft" src="images/home/location.jpg">
		<div id="locationInfo">
			Cenel Building <br> Burgos Concepcion <br> 1478 Malabon
			City
		</div>
		
		<img class="locationIcon iconLeft" src="images/home/phone.jpg">
		<div id="locationInfo">(033) 376-4362</div>
		
		<img class="locationIcon iconLeft" src="images/home/email.png">
		<div id="locationInfo">crux@upou.edu.ph</div>
		
		<a href="https://www.facebook.com/TeaPop/info"> 
			<img border="0" class="locationIcon iconLeft" src="images/facebook_logo.png" id="facebook_logo">
		</a>
		<div id="locationInfo">Like us on Facebook!</div>
	</div>
	

</div>




