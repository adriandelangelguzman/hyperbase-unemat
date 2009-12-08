1) When the session starts (the first page of your web-app), insert an object in the session. In web-apps that
require login, the user name is normally used. If your app doesn't require login, use any other object.

    request.getSession().setAttribute("user", request.getParameter("user"));
or
    request.getSession().setAttribute("initialized", "true");


2) when checking for session timeout, check if that object is available in the session. If the session has timed out since it was initialized, the session will contain no objects.

    if(request.getSession().getAttribute("user") == null){
       // the session is not initialized.
    }
or
    if(request.getSession().getAttribute("initialized") == null){
      // the session is not initialized.
    }

