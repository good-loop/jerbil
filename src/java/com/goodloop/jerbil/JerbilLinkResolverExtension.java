package com.goodloop.jerbil;

import java.util.Set;

import com.vladsch.flexmark.html.HtmlRenderer.Builder;
import com.vladsch.flexmark.html.HtmlRenderer.HtmlRendererExtension;
import com.vladsch.flexmark.html.LinkResolver;
import com.vladsch.flexmark.html.LinkResolverFactory;
import com.vladsch.flexmark.html.renderer.LinkResolverBasicContext;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataHolder;

/**
 * Wow this is a complex mess to implement a link-resolver. 
 * See https://github.com/vsch/flexmark-java/blob/master/flexmark-java-samples/src/com/vladsch/flexmark/samples/PegdownCustomLinkResolverOptions.java
 * https://github.com/vsch/flexmark-java/wiki/Extensions#wikilinks
 * @author daniel
 *
 */
class JerbilLinkResolverExtension implements Parser.ParserExtension, HtmlRendererExtension {


	public static Parser.ParserExtension create() {
		return new JerbilLinkResolverExtension();
	}

	@Override
	public void extend(Builder arg0, String arg1) {
		LinkResolverFactory lrf = new JerbilLinkResolverFactory();
		arg0.linkResolverFactory(lrf);
	}

	@Override
	public void rendererOptions(MutableDataHolder arg0) {
	}

	@Override
	public void extend(com.vladsch.flexmark.parser.Parser.Builder arg0) {
		// huh?
	}

	@Override
	public void parserOptions(MutableDataHolder arg0) {		
	}
	
}


class JerbilLinkResolverFactory implements LinkResolverFactory {

	@Override
	public boolean affectsGlobalScope() {
		return false;
	}

	@Override
	public LinkResolver apply(LinkResolverBasicContext arg0) {
		return new JerbilLinkResolver();
	}

	@Override
	public Set<Class<?>> getAfterDependents() {
		return null;
	}

	@Override
	public Set<Class<?>> getBeforeDependents() {
		return null;
	}
	
}