#!/bin/bash

XDG_CONFIG_HOME=~/.config_presentation xfce4-terminal --maximize --hide-menubar --disable-server -T "Signals" -e "`pwd`/create_demo_tab.sh signals" --tab -T "NullCheck" -e "`pwd`/create_demo_tab.sh null_check" --tab -T "NullCheck_Bench" -e "`pwd`/create_demo_tab.sh null_check_bench" --tab -T "Safepoint" -e "`pwd`/create_demo_tab.sh safepoint" &

