<section class="menu">
	<header>
		Menu Management
	</header>
	<article>
		<div class="formAdd menu_add">
			<h3>Add Menu Item</h3><hr><br>
			<div>
				<label for="menuName">Menu Name:</label>
				<input type="text" id="menuName" name="menuName" maxlength="35" autofocus required>
			</div>
			<div>
				<label for="menuDesc">Menu Description:</label>
				<textarea name="menuDesc" rows="6" maxlength="250" required></textarea>
			</div>
			<div>
				<label for="menuCode">Menu Code:</label>
				<input type="text" id="menuCode" name="menuCode" maxlength="10" required>
			</div>
			<div>
				<label for="menuDesc">Category:</label>
				<select id = "category">
	               <option value = "Milk Tea">Milk Tea</option>
	               <option value = "Meals">Meals</option>
	               <option value = "Snacks">Snacks</option>
	             </select>
			</div>
			<div>
				<label for="menuPrice">Price:</label>
				<input type="text" id="menuPrice" name="menuPrice" maxlength="3" required>
			</div>
			<div>
				<label for="menuPrice">Featured:</label>
				<input type="checkbox" id="menuFeatured" name="menuFeatured" required>
			</div>
			<div>
				<label for="menuPrice">Hidden:</label>
				<input type="checkbox" id="menuHidden" name="menuHidden" required>
			</div>
			<div>
			 	<label for="image_file">Image: </label>
			 	<input type="file" name="image_file" id="image_file" />
			</div>
			<input class="button" type="submit" value="Save">
		</div>
	</article>
</section>