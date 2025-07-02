import { HttpInterceptorFn } from '@angular/common/http';

export const tokenInterceptor: HttpInterceptorFn = (req, next) => {
  //const token = localStorage.getItem('token');
  const token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJiZW5paXRvbyIsImlkIjoxMCwiaWF0IjoxNzUxNDUzMTkwLCJleHAiOjE3NTE0NTY3OTB9.8AXQgq07gM9xTR7OQPpx0GAgDF3tKGgTAOxPs8JKKvE";

  if (token) {
    const authReq = req.clone({
      setHeaders: { Authorization: `Bearer ${token}` }
    });
    return next(authReq);
  }

  return next(req);
};
