
%global logdir %{_var}/log/%{name}
%global conf %{_sysconfdir}/sysconfig
%global init %{_sysconfdir}/init.d
%global jardir %{_datadir}/%{name}

Name: pingservice
Summary: pingservice - rest service example
Version: 0.0.2
Release: 1
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
if [ "$1" = "1" ]; then
  # first install
  /usr/sbin/groupadd -r pingservice && echo "group added"
  /usr/sbin/adduser -c "pingservice user" -g pingservice -s /sbin/nologin -r pingservice 2>/dev/null && echo "user added"
fi
if [ "$1" = "2" ]; then
  # upgrade from upgrade from an existing version to a new one
  chattr -i %{jardir}/%{name}.jar  # disable immutable
fi

%post
if [ "$1" = "1" ]; then
  chkconfig --add %{name}
  chattr +i %{jardir}/%{name}.jar
fi

%preun
if [ "$1" = "1" ]; then
  # action is an upgrade
  /etc/init.d/pingservice stop
fi
if [ "$1" = "0" ]; then
  # uninstall
  /etc/init.d/pingservice stop
  chattr -i %{jardir}/%{name}.jar  # disable immutable
fi

%postun
if [ "$1" = "1" ]; then
  # action is an upgrade
  chattr +i %{jardir}/%{name}.jar
  /etc/init.d/pingservice start
fi
if [ "$1" = "0" ]; then
  # uninstall
  %{__rm} -rf %{logdir}
  /usr/sbin/userdel -r pingservice
fi


%files
%defattr(-,root,root)

%attr(0755,root,root) %{jardir}
%attr(0755,root,root) %{logdir}

%attr(0755,root,root) %{init}/%{name}
%attr(0644,root,root) %{conf}/%{name}

%attr(0500,pingservice,pingservice) %{jardir}/%{name}.jar

