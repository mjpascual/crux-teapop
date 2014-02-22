<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<div id="header_text">Our Menu</div>
<!-- <div id="contactInfoHeader" class="short_header">Our Menu</div> -->

<div id="menu_box">
	<div id="menu_wrapper" class="menu">

		<!-- 				<div id="categories" class="categories"> -->
		<!-- 					<ul id="menu_category_links" class="category_links"> -->
		<%-- 						<s:iterator status="status" value="menu.beveragesSection.categories"> --%>
		<!-- 							<li><a class="category_link" -->
		<%-- 								data-slide-index='<s:property value="%{#status.index}" />'> <s:property --%>
		<%-- 		 								value="name" />  --%>
		<!-- 							</a></li> -->
		<%-- 						</s:iterator> --%>
		<!-- 					</ul> -->
		<!-- 				</div> -->

		<div id="categories" class="categories">
			<ul id="menu_category_links" class="category_links">
				<li><a class="category_link"> Beverage </a></li>
				<li><a class="category_link"> Food </a></li>
			</ul>
		</div>


		<div id="menu_categories" class="menu_categories">
			<s:iterator status="status" value="menu.beveragesSection.categories">
				<a class="category_link"
					data-slide-index='<s:property value="%{#status.index}" />'>
					<div>
						<s:property value="name" />
					</div>
				</a>
			</s:iterator>
		</div>

		<div class="retro_border">
			<ul id="contentSliderMenu" class="contentSliderMenu">
				<s:iterator status="status" value="menu.beveragesSection.categories">
					<li>
						<!-- category item -->
						<div class="category"
							id="itemlink<s:property value="%{#status.index}"/>">
							<div class="category_photo">
								<img src="images/categories/<s:property value="image"/>">
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
							<s:if test="showSML='Y'">
								<div class="serving">
									<div class="price">L</div>
									<div class="price">M</div>
									<div class="price">S</div>
									<div class="clear"></div>
								</div>
							</s:if>

							<s:iterator value="items">

								<div class="item">
									<div class="name">
										<strong><s:property value="name" /> </strong>
									</div>
									<div class="description">
										<s:property value="desc" />
									</div>

									<s:if test="showSML='Y'">
										<div class="price">
											<s:if test="price.large == 0">
									-
								</s:if>
											<s:else>
												<s:text name="format.money">
													<s:param value="price.large" />
												</s:text>
											</s:else>

										</div>
										<div class="price">
											<s:if test="price.regular == 0">
									-
								</s:if>
											<s:else>
												<s:text name="format.money">
													<s:param value="price.regular" />
												</s:text>
											</s:else>
										</div>
										<div class="price">
											<s:if test="price.small == 0">
									-
								</s:if>
											<s:else>
												<s:text name="format.money">
													<s:param value="price.small" />
												</s:text>
											</s:else>
										</div>
									</s:if>
									<s:else>
										<div class="price">
											<s:if test="price.regular == 0">
									-
							</s:if>
											<s:else>
												<s:text name="format.money">
													<s:param value="price.regular" />
												</s:text>
											</s:else>
										</div>
									</s:else>
									<div class="clear"></div>
								</div>
							</s:iterator>
							<div class="clear"></div>

							<!-- end category item -->
							<br />

						</div>
					</li>
				</s:iterator>
			</ul>
		</div>
	</div>

	<div class="clear"></div>
</div>

<script type="text/javascript">
	$(document).ready(function() {
		EventHandler.initMenuSliderLinks("#menu_categories");
	});

	
</script>






