from django.shortcuts import render

def home_page_view(request):
	return render(request, 'website/home.html')

def page1_page_view(request):
    return render(request, 'website/page1.html')

def page2_page_view(request):
    return render(request, 'website/page2.html')
