#PagingDemo
这个Demo虽然叫做pagingDemo，但包含了很多其他的库，也包括我个人很喜欢的一个框架。
Demo整体严格遵守MVVM框架，将数据获取、预处理、业务逻辑、状态管理、UI显示等分别按照Google推荐的项目结构分层。
主要涉及以下库：
Note：构建UI本来想用Compose的，但之前有同事在这个地方踩了坑，所以并不采用，之后的拓展可以适当尝试。

1. Retrofit：作为网络请求获取远程数据。
2. Coroutines: Kotlin的协程，用于做一些异步操作，其实我也想用Rxjava,奈何个人理解还有待加强。
3. Room：作为本地sqlite数据库，用于操作数据库的数据。
4. Navigation：用于页面之间的导航，主功能页面将会只有一个Activity以及多个fragment。
5. Moshi：用于Json数据解析，也可以用Gson，但作为一个新的工具，我还是更喜欢新的。
6. Flow：Kotlin的异步流，和Rxjava很像。
7. Paging：用于分页获取网络和数据库的数据。
8. ViewModel：用于页面的状态管理