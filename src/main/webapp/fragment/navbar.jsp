<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">My App</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link ${pageContext.request.requestURI eq pageContext.request.contextPath.concat('/index.jsp') ? 'active' : ''}"
                       href="${pageContext.request.contextPath}/">
                        Bosh sahifa
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${pageContext.request.requestURI.contains('/about.jsp') ? 'active' : ''}"
                       href="${pageContext.request.contextPath}/about.jsp">
                        Biz haqimizda
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link ${pageContext.request.requestURI.contains('/contact.jsp') ? 'active' : ''}"
                       href="${pageContext.request.contextPath}/contact.jsp">
                        Aloqa
                    </a>
                </li>
                <% if ( "ADMIN".equals(session.getAttribute("role")) ) {%>
                <li class="nav-item m-1">
                    <a href="/admin/book/create" class="btn btn-success">Create Book</a>
                </li>
                <% } %>
            </ul>

            <ul class="navbar-nav">
                <% if (session.getAttribute("id") == null ) {%>
                <li class="nav-item m-1">
                    <a href="/auth/login" class="btn btn-light">Login</a>
                </li>
                <li class="nav-item m-1">
                    <a href="/auth/register" class="btn btn-success">Register</a>
                </li>
                <% } else {%>
                <li class="nav-item m-1">
                    <a href="/auth/logout" class="btn btn-danger">Logout</a>
                </li>
                <% } %>
            </ul>
            <!--<ul class="navbar-nav">
                <c:choose>
                    <c:when test="${not empty sessionScope.user}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button"
                               data-bs-toggle="dropdown">
                                ${sessionScope.user.name}
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/profile.jsp">Profil</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Chiqish</a></li>
                            </ul>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="${pageContext.request.contextPath}/login.jsp">
                                Kirish
                            </a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>-->
        </div>
    </div>
</nav>