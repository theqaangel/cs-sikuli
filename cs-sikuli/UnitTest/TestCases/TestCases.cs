﻿using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using SikuliModule;
using UnitTest.Core;

namespace UnitTest.TestCases
{
    [TestClass]
    public class TestCases : BaseTestCase
    {
        const int Timeout5S = 5;
        const float Similarity90 = 0.90f;

        [TestMethod,
        Description("Test Exists mechanism - similarity = 90% and timeout = 5s")]
        public void TestExistsWithSimilarity90AndTimeout5()
        {
            Assert.IsFalse(SikuliAction.Exists(pattern, Similarity90, Timeout5S).IsEmpty, "Nope! It's gone...");
        }

        [TestMethod,
        Description("Test Find All mechanism - similarity = 90% and timeout = 5s")]
        public void TestFindAllWithSimilarity90AndTimeout5()
        {
            //There are 6 patterns on the test image
            List<Point> points = SikuliAction.FindAll(findAllPattern, Similarity90, Timeout5S, Rectangle.Empty);

            Assert.IsNotNull(points, "Nope! There is a problem...");
            Assert.AreEqual(6, points.Count, "Nope! They are NOT 6, they are " + points.Count);

        }

        [TestMethod,
        Description("Test Exists mechanism - default similarity and timeout")]
        public void TestExistsDefault()
        {
            Assert.IsFalse(SikuliAction.Exists(pattern).IsEmpty, "Nope! It's gone...");
        }

        [TestMethod,
        Description("Test Find All mechanism - default similarity and timeout")]
        public void TestFindAllDefault()
        {
            //There are 3 patterns on the test image
            List<Point> points = SikuliAction.FindAll(findAllPattern);

            Assert.IsNotNull(points, "Nope! There is a problem...");
            Assert.AreEqual(6, points.Count, "Nope! They are NOT 6, they are " + points.Count);
        }

        //This test strongly depends on your screen resolution. There is a possibility to fail.
        //Taskbar location on screen should not be on left side of the screen
        [TestMethod,
        Description("Test Find All in a search region mechanism - default similarity and timeout")]
        public void TestFindAllIntoRegion()
        {
            //There are 3 patterns on the test region
            Rectangle searchRegion = new Rectangle(1, 150, 300, 100);
            List<Point> points = SikuliAction.FindAll(findAllPattern, searchRegion);

            Assert.IsNotNull(points, "Nope! There is a problem...");
            Assert.AreEqual(3, points.Count, "Nope! They are NOT 3, they are " + points.Count);
        }

        [TestMethod,
        Description("Test Click mechanism - default similarity and timeout")]
        public void TestClickDefault()
        {
            try
            {
                SikuliAction.Click(pattern);
                Report.Pass("Yep! It's clicked...");
            }
            catch
            {
                Report.Error("Nope! It's NOT clicked...");
            }
        }

        [TestMethod,
        Description("Test Hover mechanism - default similarity and timeout")]
        public void TestHoverDefault()
        {
            try
            {
                SikuliAction.Hover(pattern);
                Report.Pass("Yep! It's hovered...");
            }
            catch
            {
                Report.Error("Nope! It's NOT hovered...");
            }
        }

        [TestMethod,
        Description("Test Double Click mechanism - default similarity and timeout")]
        public void TestDoubleClickDefault()
        {
            try
            {
                SikuliAction.DoubleClick(extraPattern);
                Report.Pass("Yep! It's double clicked...");
            }
            catch
            {
                Report.Error("Nope! It's NOT double clicked...");
            }
        }

        [TestMethod,
        Description("Test Right Click mechanism - default similarity and timeout")]
        public void TestRightClickDefault()
        {
            try
            {
                SikuliAction.RightClick(pattern);
                Report.Pass("Yep! It's right clicked...");
            }
            catch
            {
                Report.Error("Nope! It's NOT right clicked...");
            }
        }

        [TestMethod,
        Description("Test Drag and Drop mechanism - default similarity and timeout")]
        public void TestDragAndDropDefault()
        {
            try
            {
                SikuliAction.DragAndDrop(extraPattern, pattern);
                Report.Pass("Yep! It's drag and dropped...");
            }
            catch
            {
                Report.Error("Nope! It's NOT drag and dropped...");
            }
        }

        [TestMethod,
        Description("Test Wait Vanish mechanism - Positive")]
        public void TestWaitVanishDefaultPositive()
        {
            try
            {
                KillMSPaint(2);
                SikuliAction.WaitVanish(extraPattern, 3);
                Report.Pass("Yep! It's vanished...");
            }
            catch
            {
                Report.Error("Nope! It's NOT vanished...");
            }
        }

        [TestMethod,
        Description("Test Wait Vanish mechanism - Negative")]
        public void TestWaitVanishDefaultNegative()
        {
            try
            {
                KillMSPaint(3);
                SikuliAction.WaitVanish(extraPattern, 2);
                Report.Error("Nope! It's vanished, but it shouldn't...");
            }
            catch
            {
                Report.Pass("Yep! It's not vanished as expected...");
            }
        }

        [TestMethod,
        Description("Test Wait mechanism - Positive")]
        public void TestWaitDefaultPositive()
        {
            try
            {
                StartMSPaint(2);
                SikuliAction.Wait(extraPattern, 3);
                Report.Pass("Yep! It's appeared...");
            }
            catch
            {
                Report.Error("Nope! It's NOT appeared...");
            }
        }

        [TestMethod,
        Description("Test Wait mechanism - Negative")]
        public void TestWaitDefaultNegative()
        {
            try
            {
                StartMSPaint(3);
                SikuliAction.Wait(extraPattern, 2);
                Report.Error("Nope! It's appeared, but it shouldn't...");
            }
            catch
            {
                Report.Pass("Yep! It's not appeared as expected...");
            }
        }
    }
}