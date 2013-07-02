
<div class="FilterContent" data-param-name="${sectionContent.name}">
	<div class="fees_content">
		<label for="fees_amount_min"><b:translator value="fees_price" /> </label>
		<input type="text" id="fees_amount_min" class="fees_input" />
		<label for="fees_amount_min"> <b:translator value="and" />
		</label>
		<input type="text" id="fees_amount_max" class="fees_input" />
		<select>
			<c:forEach var="currency" items="${content.currencies}">
				<option>
					${currency.symbol}
					<c:out value="(${currency})"></c:out>
				</option>
			</c:forEach>
		</select>

		<div id="general-fees-range"></div>
	</div>
</div>