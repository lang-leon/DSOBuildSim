import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RuneSelector } from './rune-selector';

describe('RuneSelector', () => {
  let component: RuneSelector;
  let fixture: ComponentFixture<RuneSelector>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RuneSelector],
    }).compileComponents();

    fixture = TestBed.createComponent(RuneSelector);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
