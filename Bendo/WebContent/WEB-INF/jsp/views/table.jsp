<c:set var="table" value="${requestScope.table}" scope="page" />
<ul class="table">
	<li class="headrow">
		<ul>
			<c:forEach var="cell" items="${table.header.cells}">
				<li class="${cell.size}">
					<div class="fittext">
						<span> <b:translator value="${cell.value}" />
						</span>
					</div>
				</li>
			</c:forEach>
		</ul>
	</li>
	<c:forEach var="row" items="${table.rows}">
		<li class="row">
			<ul onclick="window.location='<c:url value='${row.link}'/>';">
				<c:forEach var="topcell" items="${table.header.cells}">
					<c:set var="cell" value="${row.getCell(topcell)}" scope="page" />
					<li class="${topcell.size} fittext">
						<div class="fittext">
							<span> <c:choose>
									<c:when test="${topcell.type == 'TEXT'}">

										<c:out value="${cell.value.toString()}" />
									</c:when>
									<c:when test="${topcell.type == 'VIEW'}">
										<c:set var="additionalColumnValue" value="${cell.value}" scope="request" />
										<c:import url="${topcell.file}" />
									</c:when>
								</c:choose>
							</span>
						</div>

					</li>
				</c:forEach>

			</ul>
		</li>

	</c:forEach>
</ul>