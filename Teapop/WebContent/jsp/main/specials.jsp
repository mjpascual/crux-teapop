<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="header_text">Specials & Promos</div>

<!-- start menu -->
<s:if test="specials != null">

<div id="specials_wrapper" class="menu">
	<div class="menu_border">
		<ul id="contentSliderMenu" class="contentSliderMenu">
			<s:if test="specials.promos.size > 0">
			<s:iterator status="status" value="specials.promos">
				<li>
					<!-- category item -->
					<div class="category"
						id="promolink<s:property value="%{#status.index}"/>">
						<div class="promo_photo_container">
							<img title="<s:property value="desc" />" class="promo_photo"
								src="images/promos/<s:property value="image"/>">
						</div>
						<div class="promo_title_desc_container">
							<div class="promoTitle_container">
								<s:property value="name" />
							</div>

							<div class="promoDetails">
								<s:property value="desc" />
							</div>
							<div class="clear"></div>
						</div>
					</div>
				</li>
			</s:iterator>
			</s:if>
			<s:else>
				There are no items added in this section yet.
			</s:else>
		</ul>
	</div>
</div>
</s:if>
<s:else>
<br/>
<center>
There was a problem with retrieving the Specials & Promos. Please try again later.
</center>
</s:else>
<script type="text/javascript">
	$(document).ready(function() {
		EventHandler.initSpecialsSliderLinks(".contentSliderMenu");
	});
</script>