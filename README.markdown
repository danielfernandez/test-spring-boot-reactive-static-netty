Test Repository for Static Resource Resolution (Spring Web Reactive + Netty)
----------------------------------------------------------------------------

Issue Link: https://jira.spring.io/browse/SPR-15XXX

This repository is aimed at testing an exception happening when accessing a static resource (an image)
on a Spring Web Reactive application using Netty.

This application was created using `http://start.spring.io`. Minor modifications to the `pom.xml` were done
in order to use Netty instead of the default Tomcat.

## How to test

Compile and run:

```
mvn -U clean compile spring-boot:run
```

Access the static resource from a browser or `curl`:

```
curl http://localhost:8080/images/logo.png
```

## Observed Results

The following exception is thrown:

```
2016-12-03 17:55:34.082 ERROR 14751 --- [ctor-http-nio-2] o.s.w.s.h.ExceptionHandlingWebHandler    : Could not complete request

io.netty.handler.codec.EncoderException: java.lang.IllegalStateException: unexpected message type: DefaultFileRegion
	at io.netty.handler.codec.MessageToMessageEncoder.write(MessageToMessageEncoder.java:106) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.CombinedChannelDuplexHandler.write(CombinedChannelDuplexHandler.java:345) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeWrite0(AbstractChannelHandlerContext.java:749) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeWrite(AbstractChannelHandlerContext.java:741) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:827) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:734) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.ChannelDuplexHandler.write(ChannelDuplexHandler.java:106) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.handler.codec.http.HttpServerKeepAliveHandler.write(HttpServerKeepAliveHandler.java:87) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeWrite0(AbstractChannelHandlerContext.java:749) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeWrite(AbstractChannelHandlerContext.java:741) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:827) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:734) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.ChannelDuplexHandler.write(ChannelDuplexHandler.java:106) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeWrite0(AbstractChannelHandlerContext.java:749) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.AbstractChannelHandlerContext.invokeWriteAndFlush(AbstractChannelHandlerContext.java:812) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.AbstractChannelHandlerContext.write(AbstractChannelHandlerContext.java:825) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.AbstractChannelHandlerContext.writeAndFlush(AbstractChannelHandlerContext.java:805) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.AbstractChannelHandlerContext.writeAndFlush(AbstractChannelHandlerContext.java:842) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.DefaultChannelPipeline.writeAndFlush(DefaultChannelPipeline.java:1032) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.channel.AbstractChannel.writeAndFlush(AbstractChannel.java:296) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at reactor.ipc.netty.channel.ChannelOperations.lambda$sendFile$3(ChannelOperations.java:363) ~[reactor-netty-0.6.0.BUILD-SNAPSHOT.jar:na]
	at reactor.core.publisher.MonoUsing.subscribe(MonoUsing.java:83) ~[reactor-core-3.0.3.RELEASE.jar:na]
	at reactor.core.publisher.FluxConcatIterable$ConcatIterableSubscriber.onComplete(FluxConcatIterable.java:152) ~[reactor-core-3.0.3.RELEASE.jar:na]
	at reactor.core.publisher.FluxConcatIterable.subscribe(FluxConcatIterable.java:69) ~[reactor-core-3.0.3.RELEASE.jar:na]
	at reactor.core.publisher.MonoNext.subscribe(MonoNext.java:41) ~[reactor-core-3.0.3.RELEASE.jar:na]
	...
Caused by: java.lang.IllegalStateException: unexpected message type: DefaultFileRegion
	at io.netty.handler.codec.http.HttpObjectEncoder.encode(HttpObjectEncoder.java:97) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	at io.netty.handler.codec.MessageToMessageEncoder.write(MessageToMessageEncoder.java:88) ~[netty-all-4.1.6.Final.jar:4.1.6.Final]
	... 109 common frames omitted
```

