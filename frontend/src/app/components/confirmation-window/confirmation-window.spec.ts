import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfirmationWindow } from './confirmation-window';

describe('ConfirmationWindow', () => {
  let component: ConfirmationWindow;
  let fixture: ComponentFixture<ConfirmationWindow>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ConfirmationWindow],
    }).compileComponents();

    fixture = TestBed.createComponent(ConfirmationWindow);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
