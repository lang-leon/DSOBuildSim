import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CharacterResetConfirmationWindow } from './confirmation-window';

describe('CharacterResetConfirmationWindow', () => {
  let component: CharacterResetConfirmationWindow;
  let fixture: ComponentFixture<CharacterResetConfirmationWindow>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CharacterResetConfirmationWindow],
    }).compileComponents();

    fixture = TestBed.createComponent(CharacterResetConfirmationWindow);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
