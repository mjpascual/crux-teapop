<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="contactInfoHeader" class="short_header">Our Menu</div>

<div id="menu_box">
	<div id="categories" class="">
		<ul id="menu_category_links" class="category_links">
			<s:iterator status="status" value="menu.categories">
				<li><a class="category_link"
					href='#itemlink<s:property value="%{#status.index}" />'> <s:property
							value="name" />
				</a></li>
			</s:iterator>
		</ul>
	</div>

	<div id="menu_wrapper" class="menu">
		<s:iterator status="status" value="menu.categories">
			<!-- category item -->
			<div class="category"
				id="itemlink<s:property value="%{#status.index}"/>">
				<div class="category_photo">
					<img src="<s:property value="image"/>">
				</div>
				<div class="category_info">
					<div class="category_name">
						<s:property value="name" />
					</div>
					<div class="category_description">
						<s:property value="desc" />
					</div>
					<div class="clear"></div>
				</div>
				<div class="clear"></div>
				
				<div class="serving">
					<div class="price">L</div>
					<div class="price">M</div>
					<div class="price">S</div>
					<div class="clear"></div>
				</div>

				<s:iterator value="items">
				
					<div class="item">
						<div class="name"> <strong><s:property
									value="name" /> </strong>
						</div>
						<div class="description">
							<s:property value="desc" />
						</div>
						<div class="price">
							<s:if test="price.large == 0">
								-
							</s:if>
							<s:else>
								<s:property value="price.large" />
							</s:else> 
							
						</div>						
						<div class="price">
							<s:if test="price.regular == 0">
								-
							</s:if>
							<s:else>
								<s:property value="price.regular" />
							</s:else> 
						</div>
						<div class="price">
							<s:if test="price.small == 0">
								-
							</s:if>
							<s:else>
								<s:property value="price.small" />
							</s:else> 
						</div>
						<div class="clear"></div>
					</div>
				</s:iterator>
				<div class="clear"></div>

				<!-- end category item -->
				<br />

			</div>

		</s:iterator>
	</div>

	<div class="clear"></div>
</div>

<script type="text/javascript">
	 $(document).ready( function(){
		 EventHandler.initCategoryLinks("menu_category_links");
	 });
</script>






