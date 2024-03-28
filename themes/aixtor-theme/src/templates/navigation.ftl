<nav aria-label="<@liferay.language key="site-pages" />" class="${nav_css_class} navbar " id="navigation"
     role="navigation">
    <ul role="menubar" class="navbar-nav mr-auto">
        <#list nav_items as nav_item>
            <#assign
            nav_item_attr_has_popup = ""
            nav_item_css_class = "lfr-nav-item nav-item"
            nav_item_layout = nav_item.getLayout()
            nav_item_a="nav-link "
            />

            <#if nav_item.isSelected()>
                <#assign
                nav_item_attr_has_popup = "aria-haspopup='true'"
                nav_item_css_class = nav_item_css_class
                nav_item_a="nav-link active"
                />
            </#if>
            <#if nav_item.hasChildren()>
                <#assign
                nav_item_css_class = "dropdown"
                nav_item_a="nav-link dropdown-toggle "/>


            </#if>
            <li class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation">
                <a class="${nav_item_a}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()}
                   role="menuitem">
                    <span>
                        <@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}
                        <#if nav_item.hasChildren()>
                            <span class="lfr-nav-child-toggle">
                                <span class="c-inner" tabindex="-1">
                                    <svg aria-hidden="true" class="lexicon-icon lexicon-icon-angle-down" focusable="false">
                                         <use href="http://localhost:8080/o/classic-theme/images/clay/icons.svg#angle-down">
                                         </use>
                                    </svg>
                                </span>
                            </span>
                        </#if>
                    </span>
                </a>


                <#if nav_item.hasChildren()>
                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenuButton" role="menu">
                        <#list nav_item.getChildren() as nav_child>
                            <#assign
                            nav_child_css_class = "dropdown-item"
                            />

                            <#if nav_item.isSelected()>
                                <#assign
                                nav_child_css_class = nav_child_css_class+" active"
                                />
                            </#if>

                            <li class="${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}"
                                role="presentation">
                                <a class="dropdown-item" href="${nav_child.getURL()}" ${nav_child.getTarget()}
                                   role="menuitem">${nav_child.getName()}</a>
                            </li>

                        </#list>
                    </ul>
                </#if>
            </li>
        </#list>
    </ul>
</nav>


<#--<!DOCTYPE html>-->

<#--<#include init />-->

<#--<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">-->

<#--<head>-->
<#--    <title>${html_title}</title>-->
<#--    <meta content="initial-scale=1.0, width=device-width" name="viewport"/>-->
<#--    <@liferay_util["include"] page=top_head_include />-->

<#--</head>-->

<#--<body class="${css_class}">-->

<#--<@liferay_ui["quick-access"] contentId="#main-content" />-->

<#--<@liferay_util["include"] page=body_top_include />-->

<#--<@liferay.control_menu />-->

<#--<div class="container-fluid position-relative" id="wrapper">-->
<#--    <header id="banner" role="banner">-->
<#--        <div id="heading" class="navbar navbar-classic navbar-top py-3">-->
<#--            <div aria-level="1" class="container-fluid container-fluid-max-xl user-personal-bar" role="heading">-->
<#--                <div class="align-items-center autofit-row">-->
<#--                    <a class="${logo_css_class}" href="${site_default_url}"-->
<#--                       title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">-->
<#--                        <img class="mr-2" alt="${logo_description}" height="${site_logo_height}" src="${site_logo}"-->
<#--                             width="${site_logo_width}"/>-->
<#--                    </a>-->

<#--                    <#if show_site_name>-->
<#--                        <span class="font-weight-bold h2 mb-0 text-dark"-->
<#--                              title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">-->
<#--						${site_name}-->
<#--					</span>-->

<#--                    </#if>-->
<#--                    <div class="autofit-col autofit-col-expand">-->
<#--                        <div class="justify-content-md-end mr-4 navbar-form" role="search">-->
<#--                            <span><@liferay.user_personal_bar /> </span>-->
<#--                            <span><@liferay_portlet["runtime"]-->
<#--                                portletProviderAction=portletProviderAction.VIEW-->
<#--                                portletProviderClassName="com.liferay.portal.kernel.servlet.taglib.ui.LanguageEntry"-->
<#--                                /> </span>-->
<#--                        </div>-->
<#--                    </div>-->
<#--                </div>-->
<#--            </div>-->

<#--        </div>-->

<#--        &lt;#&ndash;        <#if !is_signed_in>&ndash;&gt;-->
<#--        &lt;#&ndash;            <a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in"&ndash;&gt;-->
<#--        &lt;#&ndash;               rel="nofollow">${sign_in_text}</a>&ndash;&gt;-->
<#--        &lt;#&ndash;        </#if>&ndash;&gt;-->

<#--        &lt;#&ndash;        <#if is_signed_in>&ndash;&gt;-->
<#--        &lt;#&ndash;            <a data-redirect="${is_login_redirect_required?string}" href="${sign_out_url}" id="sign-out"&ndash;&gt;-->
<#--        &lt;#&ndash;               rel="nofollow">${sign_out_text}</a>&ndash;&gt;-->
<#--        &lt;#&ndash;        </#if>&ndash;&gt;-->

<#--        <#if has_navigation && is_setup_complete>-->
<#--            <#include "${full_templates_path}/navigation.ftl" />-->
<#--        </#if>-->
<#--    </header>-->
<#--    <#assign-->

<#--    employeeLocalService = serviceLocator.findService("com.aixtor.employee.service.EmployeeLocalService")-->
<#--    totalEmployee = employeeLocalService.getEmployeesCount()-->
<#--    />-->
<#--    <span>Total Employee: ${totalEmployee}</span>-->

<#--    <section id="content">-->
<#--        <h2 class="hide-accessible sr-only" role="heading" aria-level="1">${htmlUtil.escape(the_title)}</h2>-->

<#--        <#if selectable>-->
<#--            <@liferay_util["include"] page=content_include />-->
<#--        <#else>-->
<#--            ${portletDisplay.recycle()}-->

<#--            ${portletDisplay.setTitle(the_title)}-->

<#--            <@liferay_theme["wrap-portlet"] page="portlet.ftl">-->
<#--                <@liferay_util["include"] page=content_include />-->
<#--            </@>-->
<#--        </#if>-->
<#--    </section>-->


<#--    <footer id="footer" role="contentinfo">-->
<#--        <p class="powered-by">-->
<#--            <@liferay.language_format-->
<#--            arguments='<a href="http://www.liferay.com" rel="external">Liferay</a>'-->
<#--            key="powered-by-x"-->
<#--            />-->
<#--        </p>-->
<#--    </footer>-->
<#--</div>-->

<#--<@liferay_util["include"] page=body_bottom_include />-->

<#--<@liferay_util["include"] page=bottom_include />-->

<#--</body>-->

<#--</html>-->

<#--<!DOCTYPE html>-->

<#--<#include init />-->

<#--<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">-->

<#--<head>-->
<#--	<title>${html_title}</title>-->

<#--	<meta content="initial-scale=1.0, width=device-width" name="viewport" />-->

<#--	<@liferay_util["include"] page=top_head_include />-->
<#--</head>-->

<#--<body class="${css_class}">-->

<#--<@liferay_ui["quick-access"] contentId="#main-content" />-->

<#--<@liferay_util["include"] page=body_top_include />-->

<#--<@liferay.control_menu />-->

<#--<div class="container-fluid position-relative" id="wrapper">-->
<#--	<header id="banner" role="banner">-->
<#--		<div id="heading">-->
<#--			<div aria-level="1" class="site-title" role="heading">-->
<#--				<a class="${logo_css_class}" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">-->
<#--					<img alt="${logo_description}" height="${site_logo_height}" src="${site_logo}" width="${site_logo_width}" />-->
<#--				</a>-->

<#--				<#if show_site_name>-->
<#--					<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">-->
<#--						${site_name}-->
<#--					</span>-->
<#--				</#if>-->
<#--			</div>-->
<#--		</div>-->

<#--		<#if !is_signed_in>-->
<#--			<a data-redirect="${is_login_redirect_required?string}" href="${sign_in_url}" id="sign-in" rel="nofollow">${sign_in_text}</a>-->
<#--		</#if>-->

<#--		<#if is_signed_in>-->
<#--			<a data-redirect="${is_login_redirect_required?string}" href="${sign_out_url}" id="sign-out" rel="nofollow">${sign_out_text}</a>-->
<#--		</#if>-->

<#--		<#if has_navigation && is_setup_complete>-->
<#--			<@liferay.user_personal_bar />-->
<#--			<#include "${full_templates_path}/navigation.ftl" />-->
<#--		</#if>-->
<#--	</header>-->

<#--	<section id="content">-->
<#--		<h2 class="hide-accessible sr-only" role="heading" aria-level="1">${htmlUtil.escape(the_title)}</h2>-->
<#--		<#assign-->

<#--		employeeLocalService = serviceLocator.findService("com.aixtor.training.liferay.service.EmployeeLocalService")-->
<#--		totalEmployee = employeeLocalService.getEmployeesCount()-->

<#--		/>-->
<#--		<#if selectable>-->
<#--			<@liferay_util["include"] page=content_include />-->
<#--		<#else>-->
<#--			${portletDisplay.recycle()}-->

<#--			${portletDisplay.setTitle(the_title)}-->

<#--			<@liferay_theme["wrap-portlet"] page="portlet.ftl">-->
<#--				<@liferay_util["include"] page=content_include />-->
<#--			</@>-->
<#--		</#if>-->
<#--	</section>-->

<#--	<footer id="footer" role="contentinfo">-->
<#--		<p class="powered-by">-->
<#--			<@liferay.language_format-->
<#--				arguments='<a href="http://www.liferay.com" rel="external">Liferay</a>'-->
<#--				key="powered-by-x"-->
<#--			/>-->
<#--		</p>-->
<#--	</footer>-->
<#--</div>-->

<#--<@liferay_util["include"] page=body_bottom_include />-->

<#--<@liferay_util["include"] page=bottom_include />-->

<#--</body>-->

<#--</html>-->

<#--<nav aria-label="<@liferay.language key="site-pages" />" class="${nav_css_class} navbar " id="navigation"-->
<#--     role="navigation">-->
<#--    <ul role="menubar" class="navbar-nav mr-auto">-->
<#--        <#list nav_items as nav_item>-->
<#--            <#assign-->
<#--            nav_item_attr_has_popup = ""-->
<#--            nav_item_css_class = "lfr-nav-item nav-item"-->
<#--            nav_item_layout = nav_item.getLayout()-->
<#--            nav_item_a="nav-link "-->
<#--            />-->

<#--            <#if nav_item.isSelected()>-->
<#--                <#assign-->
<#--                nav_item_attr_has_popup = "aria-haspopup='true'"-->
<#--                nav_item_css_class = nav_item_css_class-->
<#--                nav_item_a="nav-link active"-->
<#--                />-->
<#--            </#if>-->
<#--            <#if nav_item.hasChildren()>-->
<#--                <#assign-->
<#--                nav_item_css_class = "dropdown"-->
<#--                nav_item_a="nav-link dropdown-toggle "/>-->


<#--            </#if>-->
<#--            <li class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation">-->
<#--                <a class="${nav_item_a}" ${nav_item_attr_has_popup} href="${nav_item.getURL()}" ${nav_item.getTarget()}-->
<#--                   role="menuitem">-->
<#--                    <span>-->
<#--                        <@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}-->
<#--                        <#if nav_item.hasChildren()>-->
<#--                            <span class="lfr-nav-child-toggle">-->
<#--                                <span class="c-inner" tabindex="-1">-->
<#--                                    <svg aria-hidden="true" class="lexicon-icon lexicon-icon-angle-down" focusable="false">-->
<#--                                         <use href="http://localhost:8080/o/classic-theme/images/clay/icons.svg#angle-down">-->
<#--                                         </use>-->
<#--                                    </svg>-->
<#--                                </span>-->
<#--                            </span>-->
<#--                        </#if>-->
<#--                    </span>-->
<#--                </a>-->


<#--                <#if nav_item.hasChildren()>-->
<#--                    <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenuButton" role="menu">-->
<#--                        <#list nav_item.getChildren() as nav_child>-->
<#--                            <#assign-->
<#--                            nav_child_css_class = "dropdown-item"-->
<#--                            />-->

<#--                            <#if nav_item.isSelected()>-->
<#--                                <#assign-->
<#--                                nav_child_css_class = nav_child_css_class+" active"-->
<#--                                />-->
<#--                            </#if>-->

<#--                            <li class="${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}"-->
<#--                                role="presentation">-->
<#--                                <a class="dropdown-item" href="${nav_child.getURL()}" ${nav_child.getTarget()}-->
<#--                                   role="menuitem">${nav_child.getName()}</a>-->
<#--                            </li>-->

<#--                        </#list>-->
<#--                    </ul>-->
<#--                </#if>-->
<#--            </li>-->
<#--        </#list>-->
<#--    </ul>-->
<#--</nav>-->