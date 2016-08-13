
%global logdir %{_var}/log/%{name}
%global conf %{_sysconfdir}/sysconfig
%global init %{_sysconfdir}/init.d
%global jardir %{_datadir}/%{name}

%global user pingservice
%global group pingservice

Name: pingservice
Summary: pingservice - rest service example
Version: 0.0.1
Release: 4
License: GPL
Group: Applications/Internet
URL: https://github.com/scan86/peterservice_test

Source0: pingservice-%{version}.jar
Source1: pingservice.initd
Source2: pingservice.sysconfig

BuildRoot: %{_tmppath}/%{name}-%{version}-%{release}-root

BuildArch: noarch

Requires(pre): shadow-utils
Requires(pre): shadow-utils
Requires: java
Requires: procps
Requires(post): /sbin/chkconfig
Requires(preun): /sbin/chkconfig
Requires(post): /lib/lsb/init-functions
Requires(preun): /lib/lsb/init-functions

%description
This is test for devops vacancy

%prep
%build
%install
%{__rm} -rf $RPM_BUILD_ROOT
install -d -m 0755 ${RPM_BUILD_ROOT}%{jardir}
install -d -m 0755 ${RPM_BUILD_ROOT}%{init}
install -d -m 0755 ${RPM_BUILD_ROOT}%{conf}
install -d -m 0755 ${RPM_BUILD_ROOT}%{logdir}

%{__cp} -a %{SOURCE0} ${RPM_BUILD_ROOT}%{jardir}/%{name}.jar
%{__cp} -a %{SOURCE1} ${RPM_BUILD_ROOT}%{init}/%{name}
%{__cp} -a %{SOURCE2} ${RPM_BUILD_ROOT}%{conf}/%{name}

%clean
%{__rm} -rf $RPM_BUILD_ROOT

%pre
groupadd -r pingservice 2>/dev/null || :
useradd -c "pingservice user" -g pingservice -s /sbin/nologin -r pingservice 2>/dev/null || :

%post
chkconfig --add %{name}

%preun

%postun

%files
%defattr(-,root,root)

%attr(0755,root,root) %{jardir}
%attr(0755,root,root) %{logdir}

%attr(0755,root,root) %{init}/%{name}
%attr(0644,root,root) %{conf}/%{name}

%attr(0500,pingservice,pingservice) %{jardir}/%{name}.jar

