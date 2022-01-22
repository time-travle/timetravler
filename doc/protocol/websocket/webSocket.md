##Q1:Websocket是什么样的协议，具体有什么优点
Websocket是一个持久化的协议，相对于HTTP这种非持久的协议来说 支持双向通信，更灵活，更高效，可扩展性更好
Websocket是基于HTTP协议的，或者说借用了HTTP的协议来完成一部分握手
WebSocket是一种双向通信协议。在建立连接后，WebSocket服务器端和客户端都能主动向对方发送或接收数据，就像Socket一样

相比HTTP长连接，WebSocket有以下特点：
是真正的全双工方式，建立连接后客户端与服务器端是完全平等的，可以互相主动请求。
而HTTP长连接基于HTTP，是传统的客户端对服务器发起请求的模式
HTTP长连接中，每次数据交换除了真正的数据部分外，服务器和客户端还要大量交换HTTP header，
信息交换效率很低。Websocket协议通过第一个request建立了TCP连接之后，
之后交换的数据都不需要发送 HTTP header就能交换数据，
这显然和原有的HTTP协议有区别所以它需要对服务器和客户端都进行升级才能实现（主流浏览器都已支持HTML5）。
此外还有 multiplexing、不同的URL可以复用同一个WebSocket连接等功能。这些都是HTTP长连接不能做到的

WebSocket可以在浏览器里使用
支持双向通信
使用很简单

https://developer.mozilla.org/zh-CN/docs/Web/API/WebSocket

https://www.cnblogs.com/chyingp/p/websocket-deep-in.html