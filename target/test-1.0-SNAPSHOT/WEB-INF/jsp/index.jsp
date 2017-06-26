<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<html> 
    <head> 
        <title>MotoShop</title> 
    </head> 
    <body>

        <%@include file="header.jsp" %>

        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <div class="col-md-3">
                    <p class="lead">MotoShop</p>
                    <div class="list-group">
                        <a href="#" class="list-group-item">Kacige</a>
                        <a href="#" class="list-group-item">Protektori</a>
                        <a href="#" class="list-group-item">Maziva</a>
                    </div>
                </div>

                <div class="col-md-9">
                    <div class="row carousel-holder">
                        <div class="col-md-12">
                            <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="item active">
                                        <img class="slide-image" src="http://www.rolandsands.com/assets/images/pages/3274/rsd-x-motogeo-scrambler_21.jpg.ashx?w=600&h=300&mode=crop" alt="">
                                    </div>
                                    <div class="item">
                                        <img class="slide-image" src="https://images.milled.com/2016-07-25/1OGK8TIx2TKML8qn/HaESS6OV5z4c.jpg" alt="">
                                    </div>
                                    <div class="item">
                                        <img class="slide-image" src="http://18390-presscdn-0-82.pagely.netdna-cdn.com/wp-content/uploads/2017/02/Risk_Digital_MX_Gear_Group_FULL-1.jpg" alt="">
                                    </div>
                                </div>
                                <a class="left carousel-control" href="#carousel-example-generic" data-slide="prev">
                                    <span class="glyphicon glyphicon-chevron-left"></span>
                                </a>
                                <a class="right carousel-control" href="#carousel-example-generic" data-slide="next">
                                    <span class="glyphicon glyphicon-chevron-right"></span>
                                </a>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail">
                                <img src="https://s-media-cache-ak0.pinimg.com/736x/ab/84/64/ab8464c86e7d8696d1f44211d166eeb0.jpg" alt="">
                                <div class="caption">
                                    <h4 class="pull-right">150e</h4>
                                    <h4><a href="#">FOX kaciga</a>
                                    </h4>
                                     <p>Kaciga FOX, velicina L.</p>
                                 </div>
                            </div>
                        </div>

                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail">
                                <img src="https://s-media-cache-ak0.pinimg.com/736x/d9/e4/68/d9e468651ac410de88a902a882c77121.jpg" alt="">
                                <div class="caption">
                                    <h4 class="pull-right">259.99e </h4>
                                    <h4><a href="#">Dainesse odela</a>
                                    </h4>
                                    <p>Dostupno u svim velicinama.</p>
                                </div>

                            </div>
                        </div>

                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail">
                                <img src="https://s-media-cache-ak0.pinimg.com/236x/09/c4/d5/09c4d523603f4b7e342e40372b3fe216.jpg" alt="">
                                <div class="caption">
                                    <h4 class="pull-right">150e</h4>
                                    <h4><a href="#">Fox kaciga</a>
                                    </h4>
                                    <p>Fox kaciga roze boje. XL velicina.</p>
                                </div>

                            </div>
                        </div>

                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail">
                                <img src="http://shop.1stmx.co.uk/media/product/135/2016-thor-prime-fit-squad-motocross-gear-a46.jpg" alt="">
                                <div class="caption">
                                    <h4 class="pull-right">259e</h4>
                                    <h4><a href="#">Thor odela</a>
                                    </h4>
                                    <p>Dostupno u svim bojama i velicinama.</p>
                                </div>

                            </div>
                        </div>

                        <div class="col-sm-4 col-lg-4 col-md-4">
                            <div class="thumbnail">
                                <img src="http://media.freegun.com/products/2231/127/1/200x334/riding-suits-accessoires-moto-freegun-us.jpg" alt="">
                                <div class="caption">
                                    <h4 class="pull-right">33.71e </h4>
                                    <h4><a href="#">Dresovi FOX</a>
                                    </h4>
                                    <p>Dresovi marke FOX.</p>
                                </div>
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <%@include file="footer.jsp" %>
    </body> 
</html>
