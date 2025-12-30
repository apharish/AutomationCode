import {page, expect, test } from "@playwright/test";

test('Assertion Learning from Expect module', async ({ page }) => {

    await page.goto('https://kitchen.applitools.com/');
    await expect.soft(page).toHaveTitle('The Kitchen');
    // to check the wether element is present or not
    await expect.soft(page.locator("text=The Kitchen")).toHaveCount(1);
    if(page.$("text=The Kitchen")){
        console.log("Element is present on the page");
    }

    //to check element is visible or hidden
    await expect.soft(page.locator("text=Notification")).toBeVisible();
    await expect.soft(page.locator("text=Notification")).toBeHidden();

    //to check element is enabled or disabled.
    await expect.soft(page.locator("text=Notification")).toBeEnabled();
    await expect.soft(page.locator("text=Notification")).toBeDisabled();

    // to check the text present inside the element
    await expect.soft(page.locator("text=Notification")).toHaveText('Notification');
    await expect.soft(page.locator("text=Notification")).not.toHaveText('Notification');

    // to check the attribute of the element
    await expect.soft(page.locator("text=Notification")).toHaveAttribute('class', 'chakra-heading css-dpmy2a');
    await expect.soft(page.locator("text=Notification")).toHaveClass('chakra-heading css-dpmy2a');


});