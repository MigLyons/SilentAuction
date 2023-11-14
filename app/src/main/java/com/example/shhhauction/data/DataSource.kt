package com.example.shhhauction.data

import com.example.shhhauction.model.AuctionItem

object DataSource {
    var auctionItems = mapOf(
        "refrigerator" to
        AuctionItem(
            name="Refrigerator",
            description="Stainless steel, double-door, energy-efficient",
            startingBid=250.0,
            bidIncrement=20.0,
            highestBid=250.0,
        ),
        "microwave" to
                AuctionItem(
                name="Microwave",
        description="Countertop, digital display, 1000 watts",
        startingBid=70.0,
        bidIncrement=10.0,
        highestBid=70.0,
    ),
    "washing machine" to
    AuctionItem(
    name="Washing Machine",
    description="Front-loading, 4.5 cu. ft. capacity, multiple cycles",
    startingBid=300.0,
    bidIncrement=25.0,
    highestBid=300.0,
    ),
    "coffee maker" to
    AuctionItem(
    name="Coffee Maker",
    description="Programmable, 12-cup capacity, thermal carafe",
    startingBid=40.0,
    bidIncrement=5.0,
    highestBid=40.0,
    ),
    "dishwasher" to
    AuctionItem(
    name="Dishwasher",
    description="Built-in, quiet operation, stainless steel interior",
    startingBid=200.0,
    bidIncrement=15.0,
    highestBid=200.0,
    ),
        "blender" to
    AuctionItem(
    name="Blender",
    description="High-speed, multiple settings, BPA-free pitcher",
    startingBid=30.0,
    bidIncrement=5.0,
    highestBid=30.0,
    ),
    "toaster" to
    AuctionItem(
    name="Toaster",
    description="4-slice, stainless steel, adjustable browning",
    startingBid=25.0,
    bidIncrement=5.0,
    highestBid=25.0,
    ),
    "air fryer" to
    AuctionItem(
    name="Air Fryer",
    description="Digital control, healthy cooking, large capacity",
    startingBid=60.0,
    bidIncrement=10.0,
    highestBid=60.0,
    ),
    "oven range" to
    AuctionItem(
    name="Oven Range",
    description="Gas, 5-burner, convection oven",
    startingBid=350.0,
    bidIncrement=30.0,
    highestBid=350.0,
    ),
    "food processor" to
    AuctionItem(
    name="Food Processor",
    description="10-cup capacity, multiple attachments, powerful motor",
    startingBid=50.0,
    bidIncrement=10.0,
    highestBid=50.0,
    ),
    "electric kettle" to
    AuctionItem(
    name="Electric Kettle",
    description="Cordless, rapid boiling, auto shut-off",
    startingBid=25.0,
    bidIncrement=5.0,
    highestBid=25.0,
    ),
    "vacuum cleaner" to
    AuctionItem(
    name="Vacuum Cleaner",
    description="Bagless, HEPA filtration, versatile attachments",
    startingBid=80.0,
    bidIncrement=15.0,
    highestBid=80.0,
    ),
    "stand mixer" to
    AuctionItem(
    name="Stand Mixer",
    description="6-quart, planetary mixing action, durable construction",
    startingBid=150.0,
    bidIncrement=20.0,
    highestBid=150.0,
    ),
    "rice cooker" to
    AuctionItem(
    name="Rice Cooker",
    description="Fuzzy logic technology, non-stick inner pot",
    startingBid=40.0,
    bidIncrement=5.0,
    highestBid=40.0,
    ),
    "espresso machine" to
    AuctionItem(
    name="Espresso Machine",
    description="Semi-automatic, frothing wand, compact design",
    startingBid=120.0,
    bidIncrement=15.0,
    highestBid=120.0,
    )
    )
}