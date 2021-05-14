#  hello/urls.py

from django.shortcuts import render
from . import views
from django.urls import path

app_name = "website"

urlpatterns = [
    path('home', views.home_page_view, name='home'),
    path('page1', views.page1_page_view, name='page1'),
    path('page2', views.page2_page_view, name='page2'),
]
