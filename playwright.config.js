// @ts-check
import { defineConfig, devices } from '@playwright/test';

/**
 * @see https://playwright.dev/docs/test-configuration
 */
export default defineConfig({
  testDir: './tests',
  timeout: 45 * 1000,
  expect: {
    timeout: 5000
  },
  reporter: 'html',
  retries: 1,
  /* Shared settings for all the projects below. See https://playwright.dev/docs/api/class-testoptions. */
  use: {
    browserName: 'chromium',
    headless: false,
    viewport: null,

    launchOptions: {
      args: ['--start-maximized'] //to Maximize the browser window
    },
    trace: 'on-first-retry'

  },

});

